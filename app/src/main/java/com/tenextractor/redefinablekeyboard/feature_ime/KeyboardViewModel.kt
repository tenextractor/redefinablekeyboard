package com.tenextractor.redefinablekeyboard.feature_ime

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class KeyboardViewModel() : ViewModel() {
    private var _layout = mutableIntStateOf(0)
    val layout: State<Int> = _layout

    fun updateState(newState: Int) {
        _layout.intValue = newState
    }
}