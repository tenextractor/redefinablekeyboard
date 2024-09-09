package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.util.Log
import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.xInY
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object KoreanCombiner: Combiner {
    private val initials = listOf(
        'ㄱ' /*g*/,  'ㄲ' /*gg*/, 'ㄴ' /*n*/,  'ㄷ' /*d*/,
        'ㄸ' /*dd*/, 'ㄹ' /*r*/,  'ㅁ' /*m*/,  'ㅂ' /*b*/,
        'ㅃ' /*bb*/, 'ㅅ' /*s*/,  'ㅆ' /*ss*/, 'ㅇ' /*ng*/,
        'ㅈ' /*j*/,  'ㅉ' /*jj*/, 'ㅊ' /*ch*/, 'ㅋ' /*k*/,
        'ㅌ' /*t*/,  'ㅍ' /*p*/,  'ㅎ' /*h*/
    )
    private val vowels = listOf(
        'ㅏ' /*a*/,   'ㅐ' /*ae*/,  'ㅑ' /*ya*/,   'ㅒ' /*yae*/,
        'ㅓ' /*eo*/,  'ㅔ' /*e*/,   'ㅕ' /*yeo*/,  'ㅖ' /*ye*/,
        'ㅗ' /*o*/,   'ㅘ' /*o+a*/, 'ㅙ' /*o+ae*/, 'ㅚ' /*o+i*/,
        'ㅛ' /*yo*/,  'ㅜ' /*u*/,   'ㅝ' /*u+eo*/, 'ㅞ' /*u+e*/,
        'ㅟ' /*u+i*/, 'ㅠ' /*yu*/,  'ㅡ' /*eu*/,   'ㅢ' /*eu+i*/,
        'ㅣ' /*i*/
    )
    private val finals = listOf(
        null,       'ㄱ' /*g*/,  'ㄲ' /*gg*/, 'ㄳ' /*gs*/,
        'ㄴ' /*n*/,  'ㄵ' /*nj*/, 'ㄶ' /*nh*/, 'ㄷ' /*d*/,
        'ㄹ' /*r*/,  'ㄺ' /*rg*/, 'ㄻ' /*rm*/, 'ㄼ' /*rb*/,
        'ㄽ' /*rs*/, 'ㄾ' /*rt*/, 'ㄿ' /*rp*/, 'ㅀ' /*rh*/,
        'ㅁ' /*m*/,  'ㅂ' /*b*/,  'ㅄ' /*bs*/, 'ㅅ' /*s*/,
        'ㅆ' /*ss*/, 'ㅇ' /*ng*/, 'ㅈ' /*j*/,  'ㅊ' /*ch*/,
        'ㅋ' /*k*/,  'ㅌ' /*t*/,  'ㅍ' /*p*/,  'ㅎ' /*h*/
    )
    private const val GA_LOCATION = '가'.code //44032
    private val initialClusters = mapOf(
        'ㄱ' to "ㄲ",
        'ㄷ' to "ㄸ",
        'ㅂ' to "ㅃ",
        'ㅅ' to "ㅆ",
        'ㅈ' to "ㅉ"
    )
    private val mergedClusters = mapOf(
        "ㅗㅏ" to 'ㅘ',
        "ㅗㅐ" to 'ㅙ',
        "ㅗㅣ" to 'ㅚ',
        "ㅜㅓ" to 'ㅝ',
        "ㅜㅔ" to 'ㅞ',
        "ㅜㅣ" to 'ㅟ',
        "ㅡㅣ" to 'ㅢ', //vowels

        "ㅐㅐ" to 'ㅒ',
        "ㅔㅔ" to 'ㅒ', //gboard uses these mappings

        "ㄱㄱ" to 'ㄲ',
        "ㄱㅅ" to 'ㄳ',
        "ㄴㅈ" to 'ㄵ',
        "ㄴㅎ" to 'ㄶ',
        "ㄹㄱ" to 'ㄺ',
        "ㄹㅁ" to 'ㄻ',
        "ㄹㅂ" to 'ㄼ',
        "ㄹㅅ" to 'ㄽ',
        "ㄹㅌ" to 'ㄾ',
        "ㄹㅍ" to 'ㄿ',
        "ㄹㅎ" to 'ㅀ',
        "ㅂㅅ" to 'ㅄ',
        "ㅅㅅ" to 'ㅆ' //finals
    )
    private val splitClusters = mapOf(
        'ㅘ' to "ㅗㅏ",
        'ㅙ' to "ㅗㅐ",
        'ㅚ' to "ㅗㅣ",
        'ㅝ' to "ㅜㅓ",
        'ㅞ' to "ㅜㅔ",
        'ㅟ' to "ㅜㅣ",
        'ㅢ' to "ㅡㅣ", //vowels

        'ㄲ' to "ㄱㄱ",
        'ㄳ' to "ㄱㅅ",
        'ㄵ' to "ㄴㅈ",
        'ㄶ' to "ㄴㅎ",
        'ㄺ' to "ㄹㄱ",
        'ㄻ' to "ㄹㅁ",
        'ㄼ' to "ㄹㅂ",
        'ㄽ' to "ㄹㅅ",
        'ㄾ' to "ㄹㅌ",
        'ㄿ' to "ㄹㅍ",
        'ㅀ' to "ㄹㅎ",
        'ㅄ' to "ㅂㅅ",
        'ㅆ' to "ㅅㅅ", //finals
    )
    private fun toBlock(initial: Char, vowel: Char, final: Char?): Char {
        //merge initial, vowel and optional final letters into a hangul syllable block
        //using this formula: syllable = [(initial) × 588 + (vowel) × 28 + (final)] + 44032
        return (GA_LOCATION + 588*initials.binarySearch(initial) + 28*vowels.binarySearch(vowel) +
                if (final != null) finals.binarySearch(final) else 0).toChar()
    }
    private fun toLetters(block: Char): Array<Char?> {
        val syllableNum = block.code - GA_LOCATION
        val initialNum = syllableNum/588
        val vowelNum = (syllableNum - initialNum*588)/28
        val finalNum = syllableNum - initialNum*588 - vowelNum*28

        return arrayOf(initials[initialNum], vowels[vowelNum], finals[finalNum])
    }

    override fun combine(key: Key, inputConnection: InputConnection) {
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)
        if (charBefore != null) if (charBefore.length == 1) {
            if (initialClusters.containsKey(charBefore[0]) && key.text[0] == charBefore[0]) {
                inputConnection.deleteSurroundingText(1, 0)
                inputConnection.commitText(initialClusters[key.text[0]]!!, 1)
                return
            }
            if (xInY(charBefore[0], initials) && xInY(key.text[0], vowels)) {
                val toCommit = toBlock(charBefore[0], key.text[0], null).toString()
                inputConnection.deleteSurroundingText(1, 0)
                inputConnection.commitText(toCommit, 1)
                return
            } //if char before is an initial consonant and vowel is typed, merge them

            if (charBefore[0].code in 0xAC00..0xD7A3) {
                val syllableNum = charBefore[0].code - GA_LOCATION
                val initialNum = syllableNum/588
                val initial = initials[initialNum]
                val vowelNum = (syllableNum - initialNum*588)/28
                val vowel = vowels[vowelNum]
                val finalNum = syllableNum - initialNum*588 - vowelNum*28
                val final = finals[finalNum]

                if (final == null) { //charBefore is Consonant + Vowel
                    if (mergedClusters.containsKey(vowel.toString() + key.text[0])) {
                        val toCommit = toBlock(initial, mergedClusters[vowel.toString() + key.text[0]]!!, null).toString()
                        inputConnection.deleteSurroundingText(1, 0)
                        inputConnection.commitText(toCommit, 1)
                        return
                    } //if no final and a vowel is added that can combine with the vowel of the block, merge them
                    if (xInY(key.text[0], finals)) {
                        inputConnection.deleteSurroundingText(1, 0)
                        inputConnection.commitText(toBlock(initial, vowel, key.text[0]).toString(), 1)
                        return
                    } //if no final and a final is added, merge them
                } else { //charBefore is Consonant + Vowel + Final
                    if (mergedClusters.containsKey(final.toString() + key.text[0])) {
                        val toCommit = toBlock(initial, vowel, mergedClusters[final.toString() + key.text[0]]).toString()
                        inputConnection.deleteSurroundingText(1, 0)
                        inputConnection.commitText(toCommit, 1)
                        return
                    } //if the final of the last block can be merged with the typed character, merge them
                    if (xInY(key.text[0], vowels)) {
                        if (splitClusters.containsKey(final)) {
                            val toCommit = toBlock(initial, vowel, splitClusters[final]!![0]).toString() +
                                    toBlock(splitClusters[final]!![1], key.text[0], null)
                            Log.d("mytag", "tocommit ${toCommit.length}")
                            inputConnection.deleteSurroundingText(1, 0)
                            inputConnection.commitText(toCommit, 2)
                            return
                        } //if a vowel is entered and the final of the last block can be split,
                        //move the second part of the final to a new syllable block, along with the vowel
                        val toCommit = toBlock(initial, vowel, null).toString() +
                                toBlock(final, key.text[0], null)
                        inputConnection.deleteSurroundingText(1, 0)
                        inputConnection.commitText(toCommit, 2)
                        return
                    }
                }
            }
        }
        DefaultCombiner.combine(key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)
        if (charBefore != null) if (charBefore.length == 1) {
            val letters = toLetters(charBefore[0])
            inputConnection.deleteSurroundingText(1, 0)
            if (letters[2] != null) {
                inputConnection.commitText(toBlock(letters[0]!!, letters[1]!!, null).toString(), 1)
                return
            }
            inputConnection.commitText(letters[0].toString(), 1)
            return
        }

        DefaultCombiner.delete(imeService, inputConnection)
    }
}