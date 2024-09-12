package com.tenextractor.redefinablekeyboard.feature_ime

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup

@Composable
fun SwitchLayoutPopup(onDismissRequest: () -> Unit) {
    val popupWidth = 200.dp
    val popupHeight = 400.dp

    Popup(alignment = Alignment.TopCenter, offset = IntOffset(0, -500), onDismissRequest = onDismissRequest) {
        // Draw a rectangle shape with rounded corners inside the popup
        Box(
            Modifier.size(popupWidth, popupHeight).background(Color.Black)
                .border(width = 1.dp, color = Color.Gray)
        )
    }
}