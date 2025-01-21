package com.tenextractor.redefinablekeyboard.feature_config.domain

data class Key(
    val text: String,
    val label: String? = null,
    val width: Float? = null, //If null, the standard calculation applies
    //i.e. width = screen width/number of keys in row
    //If a value is specified, it is a fraction of the screen width
    val specialKey: SpecialKey? = null,
    val moveToLayer: Int? = null,
    val swipeKeys: SwipeKeys? = null
)
