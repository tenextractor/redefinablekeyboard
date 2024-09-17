package com.tenextractor.redefinablekeyboard.feature_config.domain

import com.tenextractor.redefinablekeyboard.feature_config.capitalizeKey
import com.tenextractor.redefinablekeyboard.feature_config.titleCaseKey

data class SwipeKeys(
    val up: Key? = null,
    val right: Key? = null,
    val down: Key? = null,
    val left: Key? = null
)