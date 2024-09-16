package com.tenextractor.redefinablekeyboard.feature_config

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.tenextractor.redefinablekeyboard.R
import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout

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