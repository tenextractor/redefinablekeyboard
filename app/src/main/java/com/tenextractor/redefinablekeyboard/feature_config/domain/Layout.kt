package com.tenextractor.redefinablekeyboard.feature_config.domain

import com.tenextractor.redefinablekeyboard.feature_config.alphabetKey
import com.tenextractor.redefinablekeyboard.feature_config.backSpaceKey
import com.tenextractor.redefinablekeyboard.feature_config.bottomRow
import com.tenextractor.redefinablekeyboard.feature_config.combiners.Combiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.DefaultCombiner
import com.tenextractor.redefinablekeyboard.feature_config.compileLayer
import com.tenextractor.redefinablekeyboard.feature_config.shiftKey
import com.tenextractor.redefinablekeyboard.feature_config.symbols1
import com.tenextractor.redefinablekeyboard.feature_config.symbols2
import com.tenextractor.redefinablekeyboard.feature_config.symbolsKey1
import com.tenextractor.redefinablekeyboard.feature_config.symbolsKey2
import com.tenextractor.redefinablekeyboard.feature_config.unShiftKey

data class Layout(
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
    val comma: String = ",",
    val currency: String = "¤",
    val period: String = ".",
    val space: String = " ",
    val combiner: Combiner = DefaultCombiner,
) {
    fun compile(): CompiledLayout {
        val rowStrings = layout.split("\n").map { it.trim() }
        val maxNumberOfKeys = rowStrings.maxOf { it.split(' ').size }
        val shiftAndBackspaceSize = ((maxNumberOfKeys - rowStrings[rowStrings.size - 1].split(' ').size).toFloat() / if (hasShift) 2 else 1)
            .coerceAtLeast(1F)
        val symbolsKey1 = symbolsKey1(if (bottomRowKey != null) KeyWidth.FractionWidth(.1F) else KeyWidth.FractionWidth(.15F))
        val bottomRow = bottomRow(comma, space, period, bottomRowKey)

        val baseLayer = compileLayer(layout, if (hasShift) shiftKey(shiftAndBackspaceSize) else null,
            backSpaceKey(shiftAndBackspaceSize, rightToLeft), symbolsKey1, bottomRow, decoupleRows, moveLayerKeys)
        val compiledOtherLayers = otherLayers.map { compileLayer(it, if (hasShift) shiftKey(shiftAndBackspaceSize) else null,
            backSpaceKey(shiftAndBackspaceSize, rightToLeft), symbolsKey1, bottomRow, decoupleRows, isOtherLayer = true) }

        val symbolsLayer1 = compileLayer(symbols1, symbolsKey2,
            backSpaceKey(1F, rightToLeft), alphabetKey, bottomRow, emptyList())
        val symbolsLayer2 = compileLayer(symbols2, null,
            backSpaceKey(1F, rightToLeft), alphabetKey, bottomRow, emptyList())
        val compiledCapsLayer = if (capsLayer != null) {
            compileLayer(capsLayer, unShiftKey(shiftAndBackspaceSize), backSpaceKey(shiftAndBackspaceSize, rightToLeft),
                symbolsKey1, bottomRow, emptyList())
        } else null

        return CompiledLayout(
            name = name,
            layers = listOf(baseLayer, symbolsLayer1, symbolsLayer2) + compiledOtherLayers,
            capsLayer = compiledCapsLayer,
            combiner = combiner
        )
    }
}