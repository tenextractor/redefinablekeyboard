package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object MalayalamCombiner: Combiner {
    private val indepToDepVowels = mapOf(
        'അ' to "", //a
        'ആ' to 'ാ', //aa
        'ഇ' to 'ി', //i
        'ഈ' to 'ീ', //ii
        'ഉ' to 'ു', //u
        'ഊ' to 'ൂ', //uu
        'ഋ' to 'ൃ', //vocalic r
        'ഌ' to 'ൢ', //vocalic l
        'എ' to 'െ', //e
        'ഏ' to 'േ', //ee
        'ഐ' to 'ൈ', //ai
        'ഒ' to 'ൊ', //o
        'ഓ' to 'ോ', //oo
        'ഔ' to 'ൌ', //au
        'ൠ' to 'ൄ', //vocalic rr
        'ൡ' to 'ൣ', //vocalic ll
    )
    private val depVowels = listOf(
        'ാ', //aa
        'ി', //i
        'ീ', //ii
        'ു', //u
        'ൂ', //uu
        'ൃ', //vocalic r
        'ൄ', //vocalic rr
        'െ', //e
        'േ', //ee
        'ൈ', //ai
        'ൊ', //o
        'ോ', //oo
        'ൌ', //au
        'ൢ', //vocalic l
        'ൣ', //vocalic ll
    )
    private val consonants = listOf(
        'ക', //ka
        'ഖ', //kha
        'ഗ', //ga
        'ഘ', //gha
        'ങ', //nga

        'ച', //ca
        'ഛ', //cha
        'ജ', //ja
        'ഝ', //jha
        'ഞ', //nya

        'ട', //tta
        'ഠ', //ttha
        'ഡ', //dda
        'ഢ', //ddha
        'ണ', //nna

        'ത', //ta
        'ഥ', //tha
        'ദ', //da
        'ധ', //dha
        'ന', //na
        'ഩ', //nnna

        'പ', //pa
        'ഫ', //pha
        'ബ', //ba
        'ഭ', //bha
        'മ', //ma

        'യ', //ya
        'ര', //ra
        'റ', //rra
        'ല', //la
        'ള', //lla
        'ഴ', //llla
        'വ', //va
        'ശ', //sha
        'ഷ', //ssa
        'സ', //sa
        'ഹ', //ha

        'ഺ', //ttta
    )
    private const val VIRAMA = '്'
    private val others = listOf(
        'ഁ', //candrabindu
        'ം', //anusvara
        'ഃ', //visarga
    )

    private val chilluToNormal = mapOf(
        //map of chillu letters to their normal versions
        'ൺ' to 'ണ', //nn
        'ൻ' to 'ന', //n
        'ർ' to 'റ', //rr
        'ൽ' to 'ല', //l
        'ൾ' to 'ള', //ll
    )
    private val normalToChillu = mapOf(
        //map of normal letters to their chillu versions
        'ണ' to 'ൺ', //nna
        'ന' to 'ൻ', //na
        'റ' to 'ർ', //rra
        'ല' to 'ൽ', //la
        'ള' to 'ൾ', //lla
    )
    private val chilluToCombining = mapOf(
        //map of chillu letters to letters that can combine with them if they come after their normal forms
        //example: chillu nn ൺ has a normal form nna ണ that can combine with tta ട to form a ligature ണ്ട
        'ൺ' to listOf('ട', 'ഡ', 'ൺ', 'മ'), //nn
        'ൻ' to listOf('ത', 'ഥ', 'ദ', 'ധ', 'ൻ'), //n
        'ർ' to listOf('ർ'), //rr
        'ൽ' to listOf('ൽ'), //l
        'ൾ' to listOf('ൾ'), //ll
    )
    private const val ZWNJ = '‌' //zero width non-joiner
    override fun combine(key: Key, inputConnection: InputConnection) {
        val charBeforeCursor = inputConnection.getTextBeforeCursor(1, 0)
        if (charBeforeCursor != null) if (charBeforeCursor.length == 1) {
            if (charBeforeCursor[0] == ZWNJ) if (!indepToDepVowels.containsKey(key.text[0]) &&
                consonants.binarySearch(key.text[0]) < 0 && !chilluToNormal.containsKey(key.text[0])) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                DefaultCombiner.combine(key, inputConnection)
                return
            } //if there is a zwnj before the cursor and neither a vowel, consonant or chillu is typed:
            //delete the zwnj and add the typed character
            if (chilluToNormal.containsKey(charBeforeCursor[0])) {
                //if the character before the cursor is a chillu
                if (key.text[0] == VIRAMA) {
                    val toCommit = chilluToNormal[charBeforeCursor[0]].toString() + VIRAMA + ZWNJ
                    inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                    inputConnection.commitText(toCommit, 1)
                    return
                } //if virama is typed, convert the chillu to its normal version and add a virama
                if (charBeforeCursor[0] == 'ൻ' && key.text[0] == 'ർ') {
                    inputConnection.commitText(VIRAMA.toString() + 'റ' + VIRAMA, 1)
                    return
                } //handle the 'nd' cluster
                if (chilluToCombining[charBeforeCursor[0]]!!.binarySearch(key.text[0]) >= 0) {
                    val toCommit = chilluToNormal[charBeforeCursor[0]].toString() + VIRAMA + key.text
                    inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                    inputConnection.commitText(toCommit, 1)
                    return
                } //if a letter is typed that would combine with the normal version of the chillu
                  //before cursor, convert the chillu to its normal version, add a virama to trigger
                  //the ligature, and add the letter that was typed
                if (indepToDepVowels.containsKey(key.text[0])) {
                    val toCommit = chilluToNormal[charBeforeCursor[0]].toString() + indepToDepVowels[key.text[0]]
                    inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                    inputConnection.commitText(toCommit, 1)
                    return
                } //if a vowel is typed, convert the chillu before the cursor to its normal version
                  //and add the dependent form of the vowel that was typed
            }
            if (depVowels.binarySearch(charBeforeCursor[0]) >= 0) if (key.text[0] == VIRAMA) {
                inputConnection.commitText(key.text, 1)
                return
            } //if the character before cursor is a dependent vowel and a virama is typed, add it
            if (charBeforeCursor[0] == VIRAMA) if (key.text[0] == VIRAMA) {
                inputConnection.commitText(ZWNJ.toString(), 1)
                return
            } //if the character before cursor is a virama and a virama is typed again, add a ZWNJ
              //to suppress any ligature that might be formed otherwise
        }
        southIndianCombine(indepToDepVowels, VIRAMA, others, key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        val selectedText = inputConnection.getSelectedText(0)
        if (selectedText != null) if (selectedText.isNotEmpty()) DefaultCombiner.delete(imeService, inputConnection)

        val charsBeforeCursor = inputConnection.getTextBeforeCursor(2, 0)
        if (charsBeforeCursor != null) if (charsBeforeCursor.length == 2)
            if (normalToChillu.containsKey(charsBeforeCursor[0])) if (depVowels.binarySearch(charsBeforeCursor[1]) >= 0) {
                val toCommit = normalToChillu[charsBeforeCursor[0]].toString()
                inputConnection.deleteSurroundingTextInCodePoints(2, 0)
                inputConnection.commitText(toCommit, 1)
                return
        } //if there is a consonant that has a chillu form and a dependent vowel before the cursor,
          //delete the dependent vowel and convert the consonant to its chillu form

        val charBeforeCursor = inputConnection.getTextBeforeCursor(1, 0)
        if (charBeforeCursor != null) if (charBeforeCursor.length == 1)
            if (normalToChillu.containsKey(charBeforeCursor[0])) {
                val toCommit = normalToChillu[charBeforeCursor[0]].toString()
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText(toCommit, 1)
                return
        } //if there is a consonant that has a chillu form before the cursor (with the unwritten
          //inherent vowel 'a', convert it to its chillu form to remove the inherent 'a'

        southIndianDelete(depVowels, consonants, VIRAMA, imeService, inputConnection)
    }
}