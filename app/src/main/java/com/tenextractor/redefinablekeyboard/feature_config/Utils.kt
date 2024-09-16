package com.tenextractor.redefinablekeyboard.feature_config

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.tenextractor.redefinablekeyboard.R
import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.domain.KeyWidth
import com.tenextractor.redefinablekeyboard.feature_config.domain.SwipeKeys

fun compileLayer(layerString: String, lowerLeftKey: Key?, lowerRightKey: Key?,
                 bottomLeftKey: Key, bottomRow: List<Key>, decoupleRows: List<Int>,
                 moveLayerKeys: List<String> = emptyList(), isOtherLayer: Boolean = false,
                 swipeList: List<Pair<String, SwipeKeys>>? = null
): List<List<Key>> {
    //NEEDS TO BE MOVED INTO THE LAYOUT CLASS, TO CUT DOWN ON THE HUGE NUMBER OF ARGUMENTS
    /*
    Creates this layout:
    .   .   .   .   .   .   .   .   .   .   .   .
    .   .   .   .   . layerString   .   .   .   .
    .   .   .   .   .   .   .   .   .   .   .   .
    lowerLeftKey.   .   .   .   .   lowerRightKey
    bottomLeftKey <-         bottomRow         ->
     */
    val rowStrings = layerString.split('\n').map { it.trim() }
    //return rowStrings.map { rowString -> rowString.split(' ').map { Key(text = it) } }
    val layer = rowStrings.mapIndexed { i, rowString ->
        if (i == rowStrings.size - 1) {
            val row = rowString.split(' ').map { compileKey(it, moveLayerKeys = moveLayerKeys,
                isOtherLayer = isOtherLayer, swipeList = swipeList) }.toMutableList()
            if (lowerLeftKey != null) row.add(0, lowerLeftKey)
            if (lowerRightKey != null) row.add(lowerRightKey)
            row
            //for last row of layerString (second from bottom of the whole keyboard), insert lowerLeftKey
            //and lowerRightKey
        } else if (decoupleRows.contains(i)) {
            val numberOfKeys = rowString.split(' ').size
            rowString.split(' ').map { compileKey(it, KeyWidth.FractionWidth(1F/numberOfKeys),
                moveLayerKeys, isOtherLayer, swipeList = swipeList) }
            //decouple the rows that need to be decoupled
        } else {
            rowString.split(' ').map { compileKey(it, moveLayerKeys = moveLayerKeys,
                isOtherLayer = isOtherLayer, swipeList = swipeList) }
        }
    }.toMutableList()
    layer.add(listOf(bottomLeftKey) + bottomRow)
    return layer
}

fun compileKey(text: String, width: KeyWidth = KeyWidth.WeightWidth(1F),
               moveLayerKeys: List<String> = emptyList(), isOtherLayer: Boolean = false,
               swipeList: List<Pair<String, SwipeKeys>>? = null): Key {
    //NEEDS TO BE MOVED INTO THE LAYOUT CLASS, TO CUT DOWN ON THE HUGE NUMBER OF ARGUMENTS
    val hasDottedCircle = text.contains("◌")
    val newText = text.replace("◌", "")

    return if (text in moveLayerKeys) {
        Key(text = "", label = text, width = width, moveToLayer = 3 + moveLayerKeys.indexOf(text))
    } else if (isOtherLayer) Key(text = newText, label = if (hasDottedCircle) text else null, width = width, moveToLayer = 0)
    else Key(text = newText, label = if (hasDottedCircle) text else null, width = width)
}

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