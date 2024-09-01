package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

interface Combiner {
    fun combine(key: Key, inputConnection: InputConnection)
    fun delete(imeService2: IMEService2, inputConnection: InputConnection)
}