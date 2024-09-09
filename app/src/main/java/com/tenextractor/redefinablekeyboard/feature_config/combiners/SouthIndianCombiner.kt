package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

fun southIndianCombine(indepToDepVowels: Map<Char, *>, virama: Char, others: List<Char>,
                       key: Key, inputConnection: InputConnection) {
    val charBeforeCursor = inputConnection.getTextBeforeCursor(1, 0)
    if (charBeforeCursor != null) if (charBeforeCursor.isNotEmpty()) if (charBeforeCursor[0] == virama) {
        //if the char before cursor is a virama (which means that there is a consonant before the virama)
        if (indepToDepVowels.containsKey(key.text[0])) {
            inputConnection.deleteSurroundingText(1, 0)
            inputConnection.commitText(indepToDepVowels[key.text[0]].toString(), indepToDepVowels[key.text[0]].toString().length)
            return
        } //if a vowel is input, delete the virama and add the dependent form of the vowel
        if (others.binarySearch(key.text[0]) >= 0) {
            inputConnection.deleteSurroundingText(1, 0)
            inputConnection.commitText(key.text, 1)
            return
        } //if candrabindu etc is input, delete the virama and add it
    }
    DefaultCombiner.combine(key, inputConnection) //else, fall back to default combiner
}

fun southIndianDelete(depVowels: List<Char>, consonants: List<Char>,
                      virama: Char, imeService: IMEService2, inputConnection: InputConnection) {
    val selectedText = inputConnection.getSelectedText(0)
    if (selectedText != null) if (selectedText.isNotEmpty()) DefaultCombiner.delete(imeService, inputConnection)

    val charBeforeCursor = inputConnection.getTextBeforeCursor(1, 0)
    if (charBeforeCursor != null) if (charBeforeCursor.isNotEmpty()) {
        if (charBeforeCursor[0] == virama) {
            inputConnection.deleteSurroundingText(2, 0)
            return
        } //if there is a virama, delete it along with the attached letter
        if (depVowels.binarySearch(charBeforeCursor[0]) >= 0) {
            inputConnection.deleteSurroundingText(1, 0)
            inputConnection.commitText(virama.toString(), 1)
            return
        } //if there is a dependent vowel mark, delete it and add virama
        if (consonants.binarySearch(charBeforeCursor[0]) >= 0) {
            inputConnection.commitText(virama.toString(), 1)
            return
        } //if there is a consonant letter, add a virama to remove the 'a' vowel
    }
    DefaultCombiner.delete(imeService, inputConnection) //else, fall back to default delete
}