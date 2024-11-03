package com.tenextractor.redefinablekeyboard.feature_config.domain

import kotlinx.serialization.Serializable

@Serializable
sealed class KeyWidth {
    @Serializable
    data class WeightWidth(val width: Float): KeyWidth()
    @Serializable
    data class FractionWidth(val width: Float): KeyWidth()
}