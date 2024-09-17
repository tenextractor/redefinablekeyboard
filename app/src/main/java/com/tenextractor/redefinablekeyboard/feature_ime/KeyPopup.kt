package com.tenextractor.redefinablekeyboard.feature_ime

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.notoFamily

@Composable
fun KeyPopup(key: Key, xOffset: Int) {
    //the composable that pops up while a key is pressed
    val upText = if (key.swipeKeys?.up != null)
        key.swipeKeys.up.label ?: key.swipeKeys.up.text else ""
    val leftText = if (key.swipeKeys?.left != null)
        key.swipeKeys.left.label ?: key.swipeKeys.left.text else ""
    val rightText = if (key.swipeKeys?.right != null)
        key.swipeKeys.right.label ?: key.swipeKeys.right.text else ""
    val downText = if (key.swipeKeys?.down != null)
        key.swipeKeys.down.label ?: key.swipeKeys.down.text else ""

    val swipeFontSize = 12.sp
    val swipeHeight = 20.dp

    Popup(alignment = Alignment.TopStart, offset = IntOffset(xOffset, -280)) {
        Box(
            Modifier
                .background(Color.Black)
                .border(width = 1.dp, color = Color.Gray)
                .padding(2.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = upText,
                    modifier = Modifier.heightIn(0.dp, swipeHeight),
                    color = Color.White,
                    fontFamily = notoFamily,
                    fontSize = swipeFontSize,
                    textAlign = TextAlign.Center
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = leftText,
                        modifier = Modifier.requiredWidth(10.dp).heightIn(0.dp, swipeHeight),
                        color = Color.White,
                        fontFamily = notoFamily,
                        fontSize = swipeFontSize,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = key.label ?: key.text,
                        modifier = Modifier.requiredWidth(20.dp).heightIn(0.dp, 40.dp),
                        color = Color.White,
                        fontFamily = notoFamily,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = rightText,
                        modifier = Modifier.requiredWidth(10.dp).heightIn(0.dp, swipeHeight),
                        color = Color.White,
                        fontFamily = notoFamily,
                        fontSize = swipeFontSize,
                        textAlign = TextAlign.Center
                    )
                }
                Text(
                    text = downText,
                    modifier = Modifier.heightIn(0.dp, swipeHeight),
                    color = Color.White,
                    fontFamily = notoFamily,
                    fontSize = swipeFontSize,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}