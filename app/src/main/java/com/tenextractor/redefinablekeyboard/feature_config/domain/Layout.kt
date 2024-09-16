package com.tenextractor.redefinablekeyboard.feature_config.domain

import com.tenextractor.redefinablekeyboard.feature_config.alphabetKey
import com.tenextractor.redefinablekeyboard.feature_config.backSpaceKey
import com.tenextractor.redefinablekeyboard.feature_config.bottomRow
import com.tenextractor.redefinablekeyboard.feature_config.combiners.Combiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.DefaultCombiner
import com.tenextractor.redefinablekeyboard.feature_config.shiftKey
import com.tenextractor.redefinablekeyboard.feature_config.symbols1
import com.tenextractor.redefinablekeyboard.feature_config.symbols2
import com.tenextractor.redefinablekeyboard.feature_config.symbolsKey1
import com.tenextractor.redefinablekeyboard.feature_config.symbolsKey2
import com.tenextractor.redefinablekeyboard.feature_config.unShiftKey

data class Layout( //"simple" description of layout, that gets compiled into KbLayout
    val name: String,
    val lang: String? = null,
    val layout: String,
    val capsLayer: String? = null,
    val shiftLayer: String? = null,
    val otherLayers: List<String> = emptyList(),
    val moveLayerKeys: List<String> = emptyList(),
    val decoupleRows: List<Int> = emptyList(),
    val hasShift: Boolean = true,
    val rightToLeft: Boolean = false,
    val bottomRowKey: Key? = null,
    //val popups: List<Pair<String, String>>?,
    val swipeList: List<Pair<String, SwipeKeys>>? = null,
    val comma: String = ",",
    val currency: String = "¤",
    val period: String = ".",
    val space: String = " ",
    val combiner: Combiner = DefaultCombiner,
) {
    fun compile(): KbLayout {
        val rowStrings = layout.split("\n").map { it.trim() }
        val maxNumberOfKeys = rowStrings.maxOf { it.split(' ').size }
        val shiftAndBackspaceSize = ((maxNumberOfKeys - rowStrings[rowStrings.size - 1].split(' ').size).toFloat() / if (hasShift) 2 else 1)
            .coerceAtLeast(1F)
        val symbolsKey1 = symbolsKey1(if (bottomRowKey != null) KeyWidth.FractionWidth(.1F) else KeyWidth.FractionWidth(.15F))
        val bottomRow = bottomRow(comma, space, period, bottomRowKey)

        val baseLayer = compileLayer(layout, if (hasShift) shiftKey(shiftAndBackspaceSize) else null,
            backSpaceKey(shiftAndBackspaceSize, rightToLeft), symbolsKey1, bottomRow, decoupleRows)
        val compiledOtherLayers = otherLayers.map { compileLayer(it, if (hasShift) shiftKey(shiftAndBackspaceSize) else null,
            backSpaceKey(shiftAndBackspaceSize, rightToLeft), symbolsKey1, bottomRow, decoupleRows, isOtherLayer = true
            ) }

        val symbolsLayer1 = compileLayer(symbols1, symbolsKey2,
            backSpaceKey(1F, rightToLeft), alphabetKey, bottomRow, emptyList())
        val symbolsLayer2 = compileLayer(symbols2, null,
            backSpaceKey(1F, rightToLeft), alphabetKey, bottomRow, emptyList())
        val compiledCapsLayer = if (capsLayer != null) {
            compileLayer(capsLayer, unShiftKey(shiftAndBackspaceSize), backSpaceKey(shiftAndBackspaceSize, rightToLeft),
                symbolsKey1, bottomRow, emptyList())
        } else null

        return KbLayout(
            name = name,
            layers = listOf(baseLayer, symbolsLayer1, symbolsLayer2) + compiledOtherLayers,
            capsLayer = compiledCapsLayer,
            combiner = combiner
        )
    }

    private fun compileLayer(layerString: String, lowerLeftKey: Key?, lowerRightKey: Key?,
                             bottomLeftKey: Key, bottomRow: List<Key>, decoupleRows: List<Int>,
                             isOtherLayer: Boolean = false,
    ): List<List<Key>> {
        //NEED TO CUT DOWN ON THE NUMBER OF ARGUMENTS
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
                val row = rowString.split(' ').map {
                    compileKey(it, isOtherLayer = isOtherLayer) }.toMutableList()
                if (lowerLeftKey != null) row.add(0, lowerLeftKey)
                if (lowerRightKey != null) row.add(lowerRightKey)
                row
                //for last row of layerString (second from bottom of the whole keyboard), insert lowerLeftKey
                //and lowerRightKey
            } else if (decoupleRows.contains(i)) {
                val numberOfKeys = rowString.split(' ').size
                rowString.split(' ').map {
                    compileKey(it, KeyWidth.FractionWidth(1F/numberOfKeys), isOtherLayer) }
                //decouple the rows that need to be decoupled
            } else {
                rowString.split(' ').map { compileKey(it, isOtherLayer = isOtherLayer) }
            }
        }.toMutableList()
        layer.add(listOf(bottomLeftKey) + bottomRow)
        return layer
    }

    private fun compileKey(text: String, width: KeyWidth = KeyWidth.WeightWidth(1F),
                           isOtherLayer: Boolean = false): Key {
        val hasDottedCircle = text.contains("◌")
        val newText = text.replace("◌", "")

        return Key(
            text = if (text in moveLayerKeys) "" else newText,
            label = if (text in moveLayerKeys || hasDottedCircle) text else null,
            width = width,
            moveToLayer = if (text in moveLayerKeys) 3 + moveLayerKeys.indexOf(text)
            else if (isOtherLayer) 0 else null,
            swipeKeys = swipeList?.find { it.first == text }?.second
        )
/*
        return if (text in moveLayerKeys) {
            Key(text = "", label = text, width = width, moveToLayer = 3 + moveLayerKeys.indexOf(text))
        } else if (isOtherLayer) Key(text = newText, label = if (hasDottedCircle) text else null, width = width, moveToLayer = 0)
        else Key(text = newText, label = if (hasDottedCircle) text else null, width = width)*/
    }
}