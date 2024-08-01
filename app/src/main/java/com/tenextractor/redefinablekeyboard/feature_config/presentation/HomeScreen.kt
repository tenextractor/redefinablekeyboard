package com.tenextractor.redefinablekeyboard.feature_config.presentation

import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.tenextractor.redefinablekeyboard.feature_config.inBuiltLayouts
import com.tenextractor.redefinablekeyboard.feature_config.selectedLayoutNamesToLayoutToggles
import com.tenextractor.redefinablekeyboard.feature_config.SharedPrefsManager
import com.tenextractor.redefinablekeyboard.feature_config.layoutTogglesToSelectedLayoutNames

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Column() {
        TopAppBar({ Text("Redefinable Keyboard") })
        val ctx = LocalContext.current
        ClickableText("Enable Redefinable Keyboard") {
            ctx.startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        }
        ClickableText("Switch to Redefinable Keyboard") {
            (ctx.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).showInputMethodPicker()
        }

        val sharedPrefsManager = SharedPrefsManager(ctx)
        var isDialogOpen by remember { mutableStateOf(false) }
        val layoutToggles = remember {
            selectedLayoutNamesToLayoutToggles(sharedPrefsManager.readSelectedLayouts(),
                inBuiltLayouts).toMutableStateList()
        }
        ClickableText("Select Layouts") {
            isDialogOpen = true
        }
        ClickableText("Settings") {}

        var text by remember { mutableStateOf("") }
        TextField(
            placeholder = { Text("Test keyboard here") },
            value = text,
            onValueChange = { text = it }
        )

        if (isDialogOpen) SelectLangDialog({
            sharedPrefsManager.writeSelectedLayouts(
                layoutTogglesToSelectedLayoutNames(layoutToggles, inBuiltLayouts))
            isDialogOpen = false
                                           }, layoutToggles)
    }
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    Text(text, color = Color.White, modifier = Modifier
        .clickable(true, null, null, onClick)
        .fillMaxWidth()
        .padding(15.dp), fontSize = 20.sp)
}

@Composable
fun SelectLangDialog(onDismissRequest: () -> Unit, selectedLayouts: MutableList<Boolean>) {
    Dialog(onDismissRequest = onDismissRequest, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        Card(
            modifier = Modifier
                .width(LocalConfiguration.current.screenWidthDp.dp * 0.9F)
                .height(LocalConfiguration.current.screenHeightDp.dp * 0.85F)
                .padding(16.dp),
        ) {
            val scrollState = rememberScrollState()
            Column (modifier = Modifier.verticalScroll(state = scrollState)) {
                inBuiltLayouts.mapIndexed { i, layout ->
                    Row {
                        Text(layout.name,
                            Modifier
                                .padding(15.dp), fontSize = 20.sp)
                        Spacer(Modifier.weight(1F))
                        Switch(
                            modifier = Modifier.semantics {
                                contentDescription = "Toggle layout ${layout.name}" }
                                .padding(top = 5.dp, end = 15.dp),
                            checked = selectedLayouts[i],
                            onCheckedChange = { onCheckedChange(i, it, selectedLayouts) }
                        )
                    }
                }
            }
        }
    }
}

fun onCheckedChange(index: Int, newValue: Boolean, layoutToggles: MutableList<Boolean>) {
    // only update selectedLayouts if it would contain at least 1 true value after the operation
    val updatedLayoutToggles = layoutToggles.slice(0..<index) + newValue +
            layoutToggles.slice(index+1..<layoutToggles.size)
    if (updatedLayoutToggles.reduce { acc, isSelected -> acc || isSelected })
        layoutToggles[index] = newValue
}