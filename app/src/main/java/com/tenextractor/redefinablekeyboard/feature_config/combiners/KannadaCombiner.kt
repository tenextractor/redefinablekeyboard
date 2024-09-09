package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object KannadaCombiner: Combiner {
    private val indepToDepVowels = mapOf(
        'ಅ' to "", //a
        'ಆ' to 'ಾ', //aa
        'ಇ' to 'ಿ', //i
        'ಈ' to 'ೀ', //ii
        'ಉ' to 'ು', //u
        'ಊ' to 'ೂ', //uu
        'ಋ' to 'ೃ', //vocalic r
        'ಌ' to 'ೢ', //vocalic l
        'ಎ' to 'ೆ', //e
        'ಏ' to 'ೇ', //ee
        'ಐ' to 'ೈ', //ai
        'ಒ' to 'ೊ', //o
        'ಓ' to 'ೋ', //oo
        'ಔ' to 'ೌ', //au
        'ೠ' to 'ೄ', //vocalic rr
        'ೡ' to 'ೣ', //vocalic ll
    )
    private val depVowels = listOf(
        'ಾ', //aa
        'ಿ', //i
        'ೀ', //ii
        'ು', //u
        'ೂ', //uu
        'ೃ', //vocalic r
        'ೄ', //vocalic rr
        'ೆ', //e
        'ೇ', //ee
        'ೈ', //ai
        'ೊ', //o
        'ೋ', //oo
        'ೌ', //au
        'ೢ', //vocalic l
        'ೣ', //vocalic ll
    )
    private val consonants = listOf(
        'ಕ', //ka
        'ಖ', //kha
        'ಗ', //ga
        'ಘ', //gha
        'ಙ', //nga

        'ಚ', //ca
        'ಛ', //cha
        'ಜ', //ja
        'ಝ', //jha
        'ಞ', //nya

        'ಟ', //tta
        'ಠ', //ttha
        'ಡ', //dda
        'ಢ', //ddha
        'ಣ', //nna

        'ತ', //ta
        'ಥ', //tha
        'ದ', //da
        'ಧ', //dha
        'ನ', //na

        'ಪ', //pa
        'ಫ', //pha
        'ಬ', //ba
        'ಭ', //bha
        'ಮ', //ma

        'ಯ', //ya
        'ರ', //ra
        'ಱ', //rra
        'ಲ', //la
        'ಳ', //lla
        'ವ', //va
        'ಶ', //sha
        'ಷ', //ssa
        'ಸ', //sa
        'ಹ', //ha

        'ೞ', //fa
    )
    private const val VIRAMA = '್'
    private const val NUQTA = '಼'
    private val others = listOf(
        'ಁ', //candrabindu
        'ಂ', //anusvara
        'ಃ', //visarga
        'ೱ', //jihvamuliya
        'ೲ', //upadhmaniya
    )

    override fun combine(key: Key, inputConnection: InputConnection) {
        southIndianCombine(indepToDepVowels, VIRAMA, others, key, inputConnection)
    }
    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        val selectedText = inputConnection.getSelectedText(0)
        if (selectedText != null) if (selectedText.isNotEmpty()) DefaultCombiner.delete(imeService, inputConnection)

        val charsBeforeCursor = inputConnection.getTextBeforeCursor(2, 0)
        if (charsBeforeCursor != null) if (charsBeforeCursor.length == 2)
            if (charsBeforeCursor[0] == NUQTA && charsBeforeCursor[1] == VIRAMA) {
                inputConnection.deleteSurroundingText(3, 0)
                return
            } //if there is a consonant with nuqta and virama before the cursor, delete the consonant, nuqta and virama
        southIndianDelete(depVowels, consonants, VIRAMA, imeService, inputConnection)
        //else, fall back to south indian delete
    }
}