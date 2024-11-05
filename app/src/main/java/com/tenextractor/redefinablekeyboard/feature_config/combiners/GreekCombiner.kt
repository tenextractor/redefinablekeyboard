package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object GreekCombiner: Combiner {
    override fun combine(key: Key, inputConnection: InputConnection) {
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)

        if (charBefore != null) if (charBefore.isNotEmpty()) {
            //unicode greek block: U+0370 to U+03FF
            if (charBefore[0].code in 0x370..0x3ff && key.text[0] == 'σ') {
                inputConnection.commitText("ς", 1)
                return
            } //if charbefore is a greek letter and sigma is typed, convert it to a final sigma

            if (charBefore[0] == 'ς' && key.text[0].code in 0x370..0x3ff) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText("σ" + key.text, 1)
                return
            } //if a greek letter is typed after a final sigma, convert it to a non-final sigma
        }
        DefaultCombiner.combine(key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        DefaultCombiner.delete(imeService, inputConnection)
    }

}