package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object KildinCombiner: Combiner {
    private val vowelsToLong = mapOf(
        'а' to "а̄",
        'ӓ' to "ӓ̄",
        'е' to "е̄",
        'ё' to "ё̄",
        'и' to "ӣ",
        'о' to "о̄",
        'у' to "ӯ",
        'ы' to "ы̄",
        'э' to "э̄",
        'ӭ' to "ӭ̄",
        'ю' to "ю̄",
        'я' to "я̄",

        'А' to "А̄",
        'Ӓ' to "Ӓ̄",
        'Е' to "Е̄",
        'Ё' to "Ё̄",
        'И' to "Ӣ",
        'О' to "О̄",
        'У' to "Ӯ",
        'Ы' to "Ы̄",
        'Э' to "Э̄",
        'Ӭ' to "Ӭ̄",
        'Ю' to "Ю̄",
        'Я' to "Я̄",
    )

    private const val NBSP = ' '

    override fun combine(key: Key, inputConnection: InputConnection) {
        val charBefore = inputConnection.getTextBeforeCursor(1, 0)
        if (charBefore != null) if (charBefore.length == 1) {
            if (charBefore[0] == NBSP) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText(key.text, 1)
                return
            }
            if (vowelsToLong.containsKey(charBefore[0]) && key.text.length == 1 &&
                key.text[0].lowercaseChar() == charBefore[0].lowercaseChar()) {
                inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                inputConnection.commitText(vowelsToLong[charBefore[0]], 1)
                return
            }
        }
        DefaultCombiner.combine(key, inputConnection)
    }

    override fun delete(imeService: IMEService2, inputConnection: InputConnection) {
        DefaultCombiner.delete(imeService, inputConnection)
    }
}