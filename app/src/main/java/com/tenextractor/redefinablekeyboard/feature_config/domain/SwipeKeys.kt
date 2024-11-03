package com.tenextractor.redefinablekeyboard.feature_config.domain

import kotlinx.serialization.Serializable

@Serializable
data class SwipeKeys(
    val up: Key? = null,
    val right: Key? = null,
    val down: Key? = null,
    val left: Key? = null
)