package com.tenextractor.redefinablekeyboard.feature_config.combiners

import android.view.inputmethod.InputConnection
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_ime.IMEService2

object DefaultCombiner: Combiner {
    override fun combine(key: Key, inputConnection: InputConnection) {
        inputConnection.commitText(key.text, key.text.length)
    }
    override fun delete(imeService2: IMEService2, inputConnection: InputConnection) {
        imeService2.sendDownUpKeyEvents(0x43) //KEYCODE_DEL
    }
}