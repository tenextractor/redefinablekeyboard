package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object TeluguCombiner: Combiner {
    private val indepToDepVowels = mapOf(
        'అ' to "", //a
        'ఆ' to 'ా', //aa
        'ఇ' to 'ి', //i
        'ఈ' to 'ీ', //ii
        'ఉ' to 'ు', //u
        'ఊ' to 'ూ', //uu
        'ఋ' to 'ృ', //vocalic r
        'ఌ' to 'ౢ', //vocalic l
        'ఎ' to 'ె', //e
        'ఏ' to 'ే', //ee
        'ఐ' to 'ై', //ai
        'ఒ' to 'ొ', //o
        'ఓ' to 'ో', //oo
        'ఔ' to 'ౌ', //au
        'ౠ' to 'ౄ', //vocalic rr
        'ౡ' to 'ౣ', //vocalic ll
    )
    private val depVowels = listOf( //needs to be sorted in unicode order
        'ా', //aa
        'ి', //i
        'ీ', //ii
        'ు', //u
        'ూ', //uu
        'ృ', //vocalic r
        'ౄ', //vocalic rr
        'ె', //e
        'ే', //ee
        'ై', //ai
        'ొ', //o
        'ో', //oo
        'ౌ', //au
        'ౢ', //vocalic l
        'ౣ', //vocalic ll
    )
    private val consonants = listOf( //needs to be sorted in unicode order
        'క', //ka
        'ఖ', //kha
        'గ', //ga
        'ఘ', //gha
        'ఙ', //nga

        'చ', //ca
        'ఛ', //cha
        'జ', //ja
        'ఝ', //jha
        'ఞ', //nya

        'ట', //tta
        'ఠ', //ttha
        'డ', //dda
        'ఢ', //ddha
        'ణ', //nna

        'త', //ta
        'థ', //tha
        'ద', //da
        'ధ', //dha
        'న', //na

        'ప', //pa
        'ఫ', //pha
        'బ', //ba
        'భ', //bha
        'మ', //ma

        'య', //ya
        'ర', //ra
        'ఱ', //rra
        'ల', //la
        'ళ', //lla
        'ఴ', //llla
        'వ', //va
        'శ', //sha
        'ష', //ssa
        'స', //sa
        'హ', //ha

        'ౘ', //tsa
        'ౙ', //dza
    )
    private const val VIRAMA = '్'
    private val others = listOf( //needs to be sorted in unicode order
        'ఁ', //candrabindu
        'ం', //anusvara
        'ః' //visarga
    )

    override fun combine(key: Key, inputConnection: InputConnection) {
        southIndianCombine(indepToDepVowels, VIRAMA, others, key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        southIndianDelete(depVowels, consonants, VIRAMA, imeService, inputConnection)
    }
}