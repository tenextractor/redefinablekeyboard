package com.tenextractor.redefinablekeyboard.feature_config.presentation

import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenextractor.redefinablekeyboard.BuildConfig
import com.tenextractor.redefinablekeyboard.R
import com.tenextractor.redefinablekeyboard.feature_config.notoFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavToSelectLayouts: () -> Unit, onNavToSettings: () -> Unit) {
    Column() {
        TopAppBar({ Text(stringResource(R.string.app_name)) })
        val ctx = LocalContext.current
        ClickableText(stringResource(R.string.enable_redefinable_keyboard)) {
            ctx.startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        }
        ClickableText(stringResource(R.string.switch_to_redefinable_keyboard)) {
            (ctx.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).showInputMethodPicker()
        }
        ClickableText(stringResource(R.string.select_layouts_to_use), onNavToSelectLayouts)
        //ClickableText(stringResource(R.string.settings), onNavToSettings)

        var text by remember { mutableStateOf("") }
        TextField(
            placeholder = { Text("Test keyboard here") },
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle.Default.copy(fontFamily = notoFamily)
        )
        Text("version ${BuildConfig.VERSION_NAME}", color = Color.LightGray,
            modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    Text(text, color = Color.White, modifier = Modifier
        .clickable(true, null, null, onClick)
        .fillMaxWidth()
        .padding(15.dp), fontSize = 20.sp)
}