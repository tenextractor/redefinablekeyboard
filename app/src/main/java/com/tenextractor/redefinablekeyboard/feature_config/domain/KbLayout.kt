package com.tenextractor.redefinablekeyboard.feature_config.domain

import com.tenextractor.redefinablekeyboard.feature_config.combiners.Combiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.DefaultCombiner

data class KbLayout(
    val name: String,
    val layers: List<List<List<Key>>>,
    val capsLayer: List<List<Key>>? = null,
    val capsLayers: List<List<List<Key>>>? = null,
    val shiftLayer: List<List<Key>>? = null,
    val shiftLayers: List<List<List<Key>>>? = null,
    val combiner: Combiner = DefaultCombiner
)