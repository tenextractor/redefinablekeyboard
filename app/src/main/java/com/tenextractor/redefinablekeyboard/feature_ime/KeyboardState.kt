package com.tenextractor.redefinablekeyboard.feature_ime

data class KeyboardState(
    //val isDialogOpen: Boolean = false,
    val layer: Int = 0,
    val layout: Int = 0,
    val layoutName: String = "",
    val shiftState: ShiftState = ShiftState.OFF,
    val shiftPressedAt: Long = 0,
    val buffer: String = ""
)

enum class ShiftState {
    OFF, SHIFT, CAPSLOCK
}