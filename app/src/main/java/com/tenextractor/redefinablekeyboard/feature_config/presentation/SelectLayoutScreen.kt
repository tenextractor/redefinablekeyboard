package com.tenextractor.redefinablekeyboard.feature_config.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenextractor.redefinablekeyboard.R
import com.tenextractor.redefinablekeyboard.feature_config.SharedPrefsManager
import com.tenextractor.redefinablekeyboard.feature_config.inBuiltLayouts
import com.tenextractor.redefinablekeyboard.feature_config.layoutTogglesToSelectedLayoutNames
import com.tenextractor.redefinablekeyboard.feature_config.selectedLayoutNamesToLayoutToggles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLayoutScreen() {
    val sharedPrefsManager = SharedPrefsManager(LocalContext.current)
    val layoutToggles = remember {
        selectedLayoutNamesToLayoutToggles(sharedPrefsManager.readSelectedLayouts(),
            inBuiltLayouts).toMutableStateList()
    }
    val scrollState = rememberScrollState()
    Column {
        TopAppBar({ Text(stringResource(R.string.select_layouts_to_use)) })
        Column (modifier = Modifier.verticalScroll(state = scrollState)) {
            inBuiltLayouts.mapIndexed { i, layout ->
                Row {
                    Text(layout.name,
                        Modifier
                            .padding(15.dp), fontSize = 20.sp, color = Color.White)
                    Spacer(Modifier.weight(1F))
                    Switch(
                        modifier = Modifier.semantics {
                            contentDescription = "Toggle layout ${layout.name}" }
                            .padding(top = 5.dp, end = 15.dp),
                        checked = layoutToggles[i],
                        onCheckedChange = { onCheckedChange(i, it, layoutToggles, sharedPrefsManager) }
                    )
                }
            }
        }
    }
}

fun onCheckedChange(index: Int, newValue: Boolean, layoutToggles: MutableList<Boolean>, sharedPrefsManager: SharedPrefsManager) {
    // only update selectedLayouts if it would contain at least 1 true value after the operation
    val updatedLayoutToggles = layoutToggles.slice(0..<index) + newValue +
            layoutToggles.slice(index+1..<layoutToggles.size)
    if (updatedLayoutToggles.reduce { acc, isSelected -> acc || isSelected }) {
        layoutToggles[index] = newValue
        sharedPrefsManager.writeSelectedLayouts(
            layoutTogglesToSelectedLayoutNames(layoutToggles, inBuiltLayouts)
        )
    }
}