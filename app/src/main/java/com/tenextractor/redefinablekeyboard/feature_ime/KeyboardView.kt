package com.tenextractor.redefinablekeyboard.feature_ime

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.AbstractComposeView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import com.tenextractor.redefinablekeyboard.feature_config.SharedPrefsManager
import com.tenextractor.redefinablekeyboard.feature_config.inBuiltLayouts
import com.tenextractor.redefinablekeyboard.feature_config.selectedLayoutNamesToSelectedLayouts

class KeyboardView(context: Context, /*imeService: IMEService2, private val viewModel: KeyboardViewModel*/) : AbstractComposeView(context) {
    /*private val viewModel by lazy {
        ViewModelProvider(imeService).get<KeyboardViewModel>()
    }*/

    @Composable
    override fun Content() {
        val sharedPrefsManager = SharedPrefsManager(context)
        val selectedLayouts = selectedLayoutNamesToSelectedLayouts(
            sharedPrefsManager.readSelectedLayouts(), inBuiltLayouts)
        var state by remember { mutableStateOf(KeyboardState(layout = sharedPrefsManager.readCurrentLayout() /*layout = viewModel.layout.value*/)) }
        fun updateState(newState: KeyboardState) {
            if (newState.layout != state.layout) sharedPrefsManager.writeCurrentLayout(
                newState.layout % sharedPrefsManager.readSelectedLayouts().size)
            state = newState
            //viewModel.updateState(newState.layout)
        }
        KeyboardScreen(selectedLayouts, state, ::updateState)
    }
}