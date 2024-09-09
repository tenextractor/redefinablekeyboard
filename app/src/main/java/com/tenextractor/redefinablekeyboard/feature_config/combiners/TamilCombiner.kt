package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object TamilCombiner: Combiner {
    private val indepToDepVowels = mapOf(
        'அ' to "", //a
        'ஆ' to 'ா', //aa
        'இ' to 'ி', //i
        'ஈ' to 'ீ', //ii
        'உ' to 'ு', //u
        'ஊ' to 'ூ', //uu
        'எ' to 'ெ', //e
        'ஏ' to 'ே', //ee
        'ஐ' to 'ை', //ai
        'ஒ' to 'ொ', //o
        'ஓ' to 'ோ', //oo
        'ஔ' to 'ௌ', //au
    )
    private val depVowels = listOf(
        'ா',
        'ி',
        'ீ',
        'ு',
        'ூ',
        'ெ',
        'ே',
        'ை',
        'ொ',
        'ோ',
        'ௌ',
    ) //should be in unicode sorted order
    private val consonants = listOf(
        'க', //ka
        'ங', //nga
        'ச', //ca
        'ஜ', //ja
        'ஞ', //nya
        'ட', //tta
        'ண', //nna
        'த', //ta
        'ந', //na
        'ன', //nnna
        'ப', //pa
        'ம', //ma
        'ய', //ya
        'ர', //ra
        'ற', //rra
        'ல', //la
        'ள', //lla
        'ழ', //llla
        'வ', //va
        'ஶ', //sha
        'ஷ', //ssa
        'ஸ', //sa
        'ஹ', //ha
    )
    private const val VIRAMA = '்'

    override fun combine(key: Key, inputConnection: InputConnection) {
        southIndianCombine(indepToDepVowels, VIRAMA, emptyList(), key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        southIndianDelete(depVowels, consonants, VIRAMA, imeService, inputConnection)
    }
}