package com.tenextractor.redefinablekeyboard.feature_config.domain

import kotlinx.serialization.Serializable

@Serializable
data class Key(
    val text: String,
    val label: String? = null,
    val width: KeyWidth = KeyWidth.WeightWidth(1F),
    val specialKey: SpecialKey? = null,
    val moveToLayer: Int? = null,
    val swipeKeys: SwipeKeys? = null
)
