package com.tenextractor.redefinablekeyboard.feature_ime

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.tenextractor.redefinablekeyboard.feature_config.presentation.ClickableText

@Composable
fun SwitchLayoutPopup(selectedLayoutNames: List<String>, updateLayoutIndex: (Int) -> Unit,
                      onDismissRequest: () -> Unit) {
    val popupWidth = LocalConfiguration.current.screenWidthDp.dp * 0.8F
    val maxPopupHeight = LocalConfiguration.current.screenHeightDp.dp * 0.7F
    /*val sortedLayoutNames = selectedLayoutNames.mapIndexed {index, name -> Pair(name, index) }
        .sortedBy { it.first }*/

    Popup(alignment = Alignment.BottomCenter, offset = IntOffset(0, -500), onDismissRequest = onDismissRequest) {
        Box(
            Modifier.width(popupWidth)
                .then(if (selectedLayoutNames.size > 9) {
                    Modifier.height(maxPopupHeight)
                } else Modifier)
                .background(Color.Black)
                .border(width = 1.dp, color = Color.Gray)
        ) {
            Column(
                Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
            ) {
                selectedLayoutNames.mapIndexed { index, name ->
                    ClickableText(name, onClick = { updateLayoutIndex(index) })
                }
            }
        }
    }
}