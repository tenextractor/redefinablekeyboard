package com.tenextractor.redefinablekeyboard.feature_config.domain

sealed class KeyWidth() {
    data class WeightWidth(val width: Float): KeyWidth()
    data class FractionWidth(val width: Float): KeyWidth()
}