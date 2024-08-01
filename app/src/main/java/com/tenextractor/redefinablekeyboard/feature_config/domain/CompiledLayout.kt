package com.tenextractor.redefinablekeyboard.feature_config.domain

data class CompiledLayout(
    val name: String,
    val layers: List<List<List<Key>>>,
    val capsLayer: List<List<Key>>? = null,
    val shiftLayer: List<List<Key>>? = null
)
