package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.xInY
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object BengaliCombiner: Combiner {
    private val indepToDepVowels = mapOf(
        'অ' to ""  /*a*/, 'আ' to 'া' /*aa*/,
        'ই' to 'ি' /*i*/, 'ঈ' to 'ী' /*ii*/,
        'উ' to 'ু' /*u*/, 'ঊ' to 'ূ' /*uu*/,
        'ঋ' to 'ৃ' /*voc.r*/, 'ঌ' to 'ৢ' /*voc.l*/,
        'এ' to 'ে' /*e*/, 'ঐ' to 'ৈ' /*ai*/,
        'ও' to 'ো' /*o*/, 'ঔ' to 'ৌ' /*au*/,
        'ৠ' to 'ৄ' /*voc.rr*/, 'ৡ' to 'ৣ' /*voc.ll*/
    )

    private val depVowels = listOf(
        'া' /*aa*/,
        'ি' /*i*/,  'ী' /*ii*/,
        'ু' /*u*/,  'ূ' /*uu*/,
        'ৃ' /*voc.r*/, 'ৄ' /*voc.rr*/,
        'ে' /*e*/,  'ৈ' /*ai*/,
        'ো' /*o*/,  'ৌ' /*au*/,
        'ৢ' /*voc.l*/, 'ৣ' /*voc.ll*/
    )

    private val consonants = listOf(
        'ক' /*ka*/, 'খ' /*kha*/, 'গ' /*ga*/, 'ঘ' /*gha*/, 'ঙ' /*nga*/,
        'চ' /*ca*/, 'ছ' /*cha*/, 'জ' /*ja*/, 'ঝ' /*jha*/, 'ঞ' /*nya*/,
        'ট' /*tta*/, 'ঠ' /*ttha*/, 'ড' /*dda*/, 'ঢ' /*ddha*/, 'ণ' /*nna*/,
        'ত' /*ta*/, 'থ' /*tha*/, 'দ' /*da*/, 'ধ' /*dha*/, 'ন' /*na*/,
        'প' /*pa*/, 'ফ' /*pha*/, 'ব' /*ba*/, 'ভ' /*bha*/, 'ম' /*ma*/,

        'য' /*ya*/, 'র' /*ra*/, 'ল' /*la*/, 'শ' /*sha*/, 'ষ' /*ssa*/,
        'স' /*sa*/, 'হ' /*ha*/, 'ড়' /*rra*/, 'ঢ়' /*rha*/, 'য়' /*yya*/,
        'ৰ' /*ra middle diagonal*/, 'ৱ' /*ra lower diagonal*/
    )

    private const val VIRAMA = '্'
    private const val ZWNJ = '‌'
    private val others = listOf(
        'ঁ' /*candrabindu*/, 'ং' /*anusvara*/, 'ঃ' /*visarga*/
    )

    override fun combine(key: Key, inputConnection: InputConnection) {
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)
        val keyText = key.text[0]

        if (charBefore != null) if (charBefore.isNotEmpty()) {
            if (charBefore[0] == ZWNJ)
                if (!indepToDepVowels.containsKey(keyText) && !xInY(keyText, consonants)) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                DefaultCombiner.combine(key, inputConnection)
                return
            } //if there is a zwnj before the cursor and neither a vowel or consonant is typed:
            //delete the zwnj and add the typed character

            if (charBefore[0] == VIRAMA)
                if (!indepToDepVowels.containsKey(keyText) && !xInY(keyText, consonants) &&
                    !xInY(keyText, others) && keyText != ZWNJ) {
                    inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                    inputConnection.commitText(key.text, 1)
                    return
            } //if the char before cursor is a consonant (with virama) and neither a vowel or consonant is typed:
            //delete the virama
        }
        southIndianCombine(indepToDepVowels, VIRAMA, others, key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        southIndianDelete(depVowels, consonants, VIRAMA, imeService, inputConnection)
    }


}