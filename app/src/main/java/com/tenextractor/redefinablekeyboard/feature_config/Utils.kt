package com.tenextractor.redefinablekeyboard.feature_config

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.tenextractor.redefinablekeyboard.R
import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.domain.SpecialKey
import com.tenextractor.redefinablekeyboard.feature_config.domain.SwipeKeys

fun layoutTogglesToSelectedLayoutNames(layoutToggles: List<Boolean>,
                                       allLayouts: List<KbLayout>): List<String> {
    return allLayouts.filterIndexed { i, _ -> layoutToggles[i] }.map { it.name }
}

fun selectedLayoutNamesToLayoutToggles(selectedLayoutNames: List<String>,
                                       allLayouts: List<KbLayout>): List<Boolean> {
    return allLayouts.map { selectedLayoutNames.contains(it.name) }
}

fun selectedLayoutNamesToSelectedLayouts(selectedLayoutNames: List<String>,
                                         allLayouts: List<KbLayout>): List<KbLayout> {
    return allLayouts.filter { selectedLayoutNames.contains(it.name) }
}

val notoFamily = FontFamily(
    Font(R.font.notosans_merged, FontWeight.Normal)
)

fun xInY(x: Char, y: List<Char?>): Boolean {
    return y.binarySearch(x) >= 0
}

fun cycleLayout(currentLayout: Int, recentLayouts: Array<Int>): Int {
    val currentLayoutIndex = recentLayouts.indexOf(currentLayout)
    return (currentLayoutIndex + 1) % recentLayouts.size
}

fun capitalizeKey(key: Key?): Key? {
    return if (key != null) Key(key.text.uppercase()) else null
}

fun capitalizeSwipeKeys(swipeKeys: SwipeKeys?): SwipeKeys? {
    return if (swipeKeys != null)
        SwipeKeys(up = capitalizeKey(swipeKeys.up), right = capitalizeKey(swipeKeys.right),
            down = capitalizeKey(swipeKeys.down), left = capitalizeKey(swipeKeys.left))
    else null
}

fun titleCaseKey(key: Key?): Key? {
    return if (key != null) Key(key.text.replaceFirstChar(Char::titlecase)) else null
}

fun titleCaseSwipeKeys(swipeKeys: SwipeKeys?): SwipeKeys? {
    return if (swipeKeys != null)
        SwipeKeys(up = titleCaseKey(swipeKeys.up), right = titleCaseKey(swipeKeys.right),
            down = titleCaseKey(swipeKeys.down), left = titleCaseKey(swipeKeys.left))
    else null
}

fun convertLayerToCaps(layer: List<List<Key>>): List<List<Key>> {
    return layer.map { row -> row.map { key ->
        if (key.specialKey == SpecialKey.SHIFT) key.copy(label = "⌄", specialKey = SpecialKey.UNSHIFT)
        else key.copy(text = key.text.uppercase(), label = key.label?.uppercase(),
            swipeKeys = capitalizeSwipeKeys(key.swipeKeys)
        )
    } }
}

fun convertLayerToShift(layer: List<List<Key>>): List<List<Key>> {
    return layer.map { row -> row.map { key ->
        if (key.specialKey == SpecialKey.SHIFT) key.copy(label = "⌄", specialKey = SpecialKey.UNSHIFT)
        else key.copy(text = key.text.replaceFirstChar(Char::titlecase),
            label = key.label?.replaceFirstChar(Char::titlecase),
            swipeKeys = titleCaseSwipeKeys(key.swipeKeys)
        )
    } }
}