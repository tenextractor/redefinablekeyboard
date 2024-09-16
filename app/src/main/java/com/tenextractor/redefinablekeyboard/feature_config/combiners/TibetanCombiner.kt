package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.xInY
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2
import kotlin.math.abs

object TibetanCombiner: Combiner {
    private val vowels = listOf(
        'ི', //i
        'ུ', //u
        'ེ', //e
        'ོ', //o
        'ྀ', //reversed i
    )
    private val consonants = listOf(
        'ཀ', //ka
        'ཁ', //kha
        'ག', //ga
        'གྷ', //gha
        'ང', //nga

        'ཅ', //ca
        'ཆ', //cha
        'ཇ', //ja
        'ཉ', //nya

        'ཊ', //tta
        'ཋ', //ttha
        'ཌ', //dda
        'ཌྷ', //ddha
        'ཎ', //nna

        'ཏ', //ta
        'ཐ', //tha
        'ད', //da
        'དྷ', //dha
        'ན', //na

        'པ', //pa
        'ཕ', //pha
        'བ', //ba
        'བྷ', //bha
        'མ', //ma

        'ཙ', //tsa
        'ཚ', //tsha
        'ཛ', //dza
        'ཛྷ', //dzha
        'ཝ', //wa

        'ཞ', //zha
        'ཟ', //za
        'འ', //-a
        'ཡ', //ya

        'ར', //ra
        'ལ', //la
        'ཤ', //sha
        'ཥ', //ssa
        'ས', //sa

        'ཧ', //ha
        'ཨ', //a
    )
    private val prefixes = listOf(
        'ག', //ga
        'ད', //da
        'བ', //ba
        'མ', //ma
        'འ', //-a
    )
    private val superscripts = listOf('ར', 'ལ', 'ས')
    private val subscripts = listOf('ཝ', 'ཡ', 'ར', 'ལ')
    private const val BREAK = '¦'
    private const val NBSP = ' '
    private const val DOWNARROW = '↓'
    private const val HALANTA = '྄'
    private fun normalToSubjoined(letter: Char): Char {
        return (letter.code+80).toChar()
    }
    private fun subjoinedToNormal(letter: Char): Char {
        return abs(letter.code-80).toChar()
    }

    override fun combine(key: Key, inputConnection: InputConnection) {
        if (key.text[0] == BREAK) {
            inputConnection.commitText(NBSP.toString(), 1)
            return
        }
        if (key.text[0] == DOWNARROW) {
            inputConnection.commitText(HALANTA.toString(), 1)
            return
        }

        val charsBefore = inputConnection.getTextBeforeCursor(2, 0)
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)
        if (charBefore != null) if (charBefore.length == 1) {
            if (charBefore[0] == NBSP) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText(key.text, 1)
                return
            }
            if (charBefore[0] == HALANTA) if (xInY(key.text[0], consonants)) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText(normalToSubjoined(key.text[0]).toString(), 1)
                return
            }
            if (xInY(subjoinedToNormal(charBefore[0]), subscripts)) if (key.text[0] == 'ཝ') {
                inputConnection.commitText("ྭ", 1)
                return
            }
        }

        if (charsBefore != null) if (charsBefore.length == 2) {
            if (prefixes.binarySearch(charsBefore[0]) >= 0)
                if (xInY(abs(charsBefore[1].code-80).toChar(), superscripts))
                    if (consonants.binarySearch(key.text[0]) >= 0) {
                        val toCommit = abs(charsBefore[1].code-80).toChar().toString() + normalToSubjoined(key.text[0])
                        inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                        inputConnection.commitText(toCommit, 1)
                        return
            }


            if (xInY(charsBefore[0], vowels)||xInY(subjoinedToNormal(charsBefore[0]), consonants)) {
                inputConnection.commitText(key.text, 1)
                return
            }
        }

        if (charBefore != null) if (charBefore.length == 1) {
            if (xInY(charBefore[0], superscripts)) if (xInY(key.text[0], consonants)) {
                inputConnection.commitText(normalToSubjoined(key.text[0]).toString(), 1)
                return
            }
            if (xInY(charBefore[0], consonants) || xInY(subjoinedToNormal(charBefore[0]), consonants))
                if (xInY(key.text[0], subscripts)) {
                    inputConnection.commitText(normalToSubjoined(key.text[0]).toString(), 1)
                    return
            }
        }
        DefaultCombiner.combine(key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        val selectedText = inputConnection.getSelectedText(0)
        if (selectedText != null) if (selectedText.isNotEmpty()) DefaultCombiner.delete(imeService, inputConnection)
        inputConnection.deleteSurroundingTextInCodePoints(1, 0)
    }
}