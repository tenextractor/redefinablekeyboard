package com.tenextractor.redefinablekeyboard.feature_ime

import android.content.Context
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tenextractor.redefinablekeyboard.feature_config.SharedPrefsManager
import com.tenextractor.redefinablekeyboard.feature_config.HapticFeedbackService
import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.domain.KeyWidth
import com.tenextractor.redefinablekeyboard.feature_config.domain.SpecialKey
import com.tenextractor.redefinablekeyboard.feature_config.notoFamily
import kotlinx.coroutines.delay

@Composable
fun KeyboardScreen(selectedLayouts: List<KbLayout>, state: KeyboardState, updateState: (KeyboardState) -> Unit) {
    val ctx = LocalContext.current
    val layout = selectedLayouts[state.layout % selectedLayouts.size]
    updateState(state.copy(layoutName = layout.name))
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val layer = state.layer
    val capsLayer = layout.capsLayer ?: convertLayerToCaps(layout.layers[layer])
    val shiftLayer = layout.shiftLayer ?: layout.capsLayer ?: convertLayerToShift(layout.layers[layer])
    val layerAfterShift = when (state.shiftState) {
        ShiftState.OFF -> layout.layers[layer]
        ShiftState.SHIFT -> shiftLayer
        ShiftState.CAPSLOCK -> capsLayer
    } // layer, after applying shift/caps if needed

    val defaultWidth = getDefaultWidth(layerAfterShift)
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            layerAfterShift.map { row -> Row {
                row.map { key -> KeyBox(key, screenWidth, defaultWidth, ctx, selectedLayouts, state, updateState) }
            } }
        }
    }

    if (state.isDialogOpen) SwitchLayoutPopup(selectedLayouts.map {it.name},
        { updateState(state.copy(layout = it, isDialogOpen = false)) },
        { updateState(state.copy(isDialogOpen = false)) })
}

fun convertLayerToCaps(layer: List<List<Key>>): List<List<Key>> {
    return layer.map { row -> row.map { key ->
        if (key.specialKey == SpecialKey.SHIFT) key.copy(label = "⌄", specialKey = SpecialKey.UNSHIFT)
        else if (key.label != null) key.copy(text = key.text.uppercase(), label = key.label.uppercase())
        else key.copy(text = key.text.uppercase())
    } }
} //THIS NEEDS TO BE MOVED TO compileLayout()

fun convertLayerToShift(layer: List<List<Key>>): List<List<Key>> {
    return layer.map { row -> row.map { key ->
        if (key.specialKey == SpecialKey.SHIFT) key.copy(label = "⌄", specialKey = SpecialKey.UNSHIFT)
        else if (key.label != null) key.copy(text = key.text.replaceFirstChar(Char::titlecase),
            label = key.label.replaceFirstChar(Char::titlecase))
        else key.copy(text = key.text.replaceFirstChar(Char::titlecase))
    } }
} //THIS NEEDS TO BE MOVED TO compileLayout()

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun KeyBox(key: Key, screenWidth: Dp, defaultWidth: Float, ctx: Context, selectedLayouts: List<KbLayout>,
           state: KeyboardState, updateState: (KeyboardState) -> Unit) {
    var pressed by remember { mutableStateOf(false) }
    var dragOffset by remember { mutableStateOf(Offset(0f, 0f)) }
    var dragged by remember { mutableStateOf(false) }
    val sharedPrefsManager = SharedPrefsManager(ctx)
    val hapticFeedbackService = HapticFeedbackService(ctx)
    Box(
        modifier =
            Modifier/*.pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        tryAwaitRelease()
                        pressed = true
                        pressed = false
                    }
                )
            }*/.then(if (key.swipeKeys != null) {
                Modifier.pointerInput(Unit) {
                    detectDragGestures(onDragEnd = {
                        dragged = false
                        dragOffset = Offset(0f, 0f)
                    }) { change, dragAmount ->
                        change.consume()
                        dragged = true
                        dragOffset = dragAmount
                    }
                }
            } else Modifier)
                /*.then(if (key.specialKey != SpecialKey.BACKSPACE) {
                Modifier.combinedClickable(onClick = { onPressKey(key, ctx, selectedLayouts, state, updateState) },
                    onLongClick = { onLongPressKey(key, ctx, selectedLayouts, state, updateState) })
            } else Modifier)*/
                .then(Modifier
            .width(getKeyWidth(key.width, screenWidth, defaultWidth))
            .height(56.dp))
            .then(
                if (key.specialKey == SpecialKey.SPACE) {
                    Modifier.drawWithContent {
                        drawContent()
                        val startY = size.height * 0.25f
                        val endY = size.height * 0.75f
                        val color = Color.DarkGray.copy(alpha = 0.75f)

                        drawLine(
                            color = color,
                            start = Offset(0f, startY),
                            end = Offset(0f, endY),
                            strokeWidth = 1.dp.toPx()
                        )
                        drawLine(
                            color = color,
                            start = Offset(size.width, startY),
                            end = Offset(size.width, endY),
                            strokeWidth = 1.dp.toPx()
                        )
                    }
                } else {
                    Modifier
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = key.label ?: key.text,
            color = Color.White,
            fontFamily = notoFamily,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )
    }

    if (key.specialKey == SpecialKey.BACKSPACE) {
        LaunchedEffect(pressed) {
            if (pressed) {
                if (sharedPrefsManager.isHapticFeedbackEnabled()) {
                    hapticFeedbackService.performHapticFeedback()
                }
            }
            var delay: Long = 400
            while (pressed) {
                onPressKey(key, ctx, selectedLayouts, state, updateState)
                delay(delay)
                delay = 20
            }
        }
    } else LaunchedEffect(pressed) {
        //Log.d("mytag", "offset $dragOffset $pressed $dragged")
        if (pressed && !dragged) onPressKey(key, ctx, selectedLayouts, state, updateState)
    }

    LaunchedEffect(dragged) {
        if (dragged) {
            Log.d("mytag", "offset $dragOffset $pressed $dragged")
            if (dragOffset.x >= 0) {
                onPressKey(key.swipeKeys?.right?:key, ctx, selectedLayouts, state, updateState)
            }
            if (dragOffset.x < 0) {
                onPressKey(key.swipeKeys?.left?:key, ctx, selectedLayouts, state, updateState)
            }
        }
    }
}

fun onPressKey(key: Key, ctx: Context, selectedLayouts: List<KbLayout>, state: KeyboardState, updateState: (KeyboardState) -> Unit) {
    val hapticFeedbackService = HapticFeedbackService(ctx)

    // Perform haptic feedback for non-backspace keys
    if (state.vibration && key.specialKey != SpecialKey.BACKSPACE) {
        hapticFeedbackService.performHapticFeedback()
    }

    val layout = selectedLayouts[state.layout % selectedLayouts.size]
    val inputConnection = (ctx as IMEService2).currentInputConnection
    if (key.moveToLayer != null)
        updateState(state.copy(layer = key.moveToLayer))

    if (state.shiftState == ShiftState.SHIFT && key.text != "")
        updateState(state.copy(shiftState = ShiftState.OFF))

    if (key.specialKey != null) {
        when (key.specialKey) {
            SpecialKey.BACKSPACE -> {
                layout.combiner.delete(ctx, inputConnection)
            }
            SpecialKey.CHANGELAYOUT -> {
                updateState(state.copy(shiftState = ShiftState.SHIFT))
                updateState(state.copy(shiftState = ShiftState.OFF))
                updateState(KeyboardState(layout = (state.layout + 1) % selectedLayouts.size))
            }
            SpecialKey.ENTER -> ctx.sendKeyChar('\n')
            SpecialKey.SHIFT -> updateState(state.copy(shiftState = ShiftState.SHIFT, shiftPressedAt = System.currentTimeMillis()))
            SpecialKey.UNSHIFT -> if (System.currentTimeMillis() - state.shiftPressedAt < 500) updateState(state.copy(shiftState = ShiftState.CAPSLOCK))
                else updateState(state.copy(shiftState = ShiftState.OFF))
            else -> {}
        }

    }

    if (key.text != "") {
        layout.combiner.combine(key, inputConnection)
    }
}

fun onLongPressKey(key: Key, ctx: Context, selectedLayouts: List<KbLayout>, state: KeyboardState, updateState: (KeyboardState) -> Unit) {
    if (key.specialKey != null) {
        when (key.specialKey) {
            SpecialKey.SHIFT -> updateState(state.copy(shiftState = ShiftState.CAPSLOCK))
            SpecialKey.CHANGELAYOUT -> { updateState(state.copy(isDialogOpen = true)) }
            else -> onPressKey(key, ctx, selectedLayouts, state, updateState)
        }
    } else if (key.text == "'") onPressKey(Key("\""), ctx, selectedLayouts, state, updateState)
    else if (key.text == ",") onPressKey(Key("„"), ctx, selectedLayouts, state, updateState)
    else if (key.text == ".") onPressKey(Key("“"), ctx, selectedLayouts, state, updateState)
    else onPressKey(key, ctx, selectedLayouts, state, updateState)
}

fun getKeyWidth(width: KeyWidth, screenWidth: Dp, defaultWidth: Float): Dp {
    return when (width) {
        is KeyWidth.WeightWidth -> screenWidth * defaultWidth * width.width
        is KeyWidth.FractionWidth -> screenWidth * width.width
    }
}
fun getDefaultWidth(layer: List<List<Key>>): Float {
    return 1 / layer.map { row -> row.fold(0.0F) { acc, key ->
        acc + when (key.width) {
            is KeyWidth.WeightWidth -> key.width.width
            is KeyWidth.FractionWidth -> 0F
        }
    } }.maxOrNull()!!
}