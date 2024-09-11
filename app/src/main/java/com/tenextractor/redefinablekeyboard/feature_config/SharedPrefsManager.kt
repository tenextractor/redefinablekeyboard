package com.tenextractor.redefinablekeyboard.feature_config

import android.content.Context

class SharedPrefsManager(private val context: Context) {
    private val sharedPrefsFile = "com.tenextractor.redefinablekeyboard.sharedpreferences"
    private val sharedPref = context.getSharedPreferences(sharedPrefsFile, Context.MODE_PRIVATE)
    private val selectedLayoutsKey = "selectedLayouts"
    private val currentLayoutKey = "currentLayout"
    private val hapticFeedbackEnabledKey = "hapticFeedbackEnabled"

    fun readSelectedLayouts(): List<String> {
        val selectedLayoutsString = sharedPref.getString(selectedLayoutsKey, "")!!
        if (selectedLayoutsString == "") {
            writeSelectedLayouts(listOf(inBuiltLayouts[0].name))
            return listOf(inBuiltLayouts[0].name)
        }
        return selectedLayoutsString.trim().split('\n')
    }

    fun writeSelectedLayouts(selectedLayoutNames: List<String>) {
        val selectedLayoutsString = selectedLayoutNames.fold("") { acc, name ->
            acc + name + '\n'}

        writeCurrentLayout(0)
        with (sharedPref.edit()) {
            putString(selectedLayoutsKey, selectedLayoutsString)
            apply()
        }
    }

    fun readCurrentLayout(): Int {
        val currentLayout = sharedPref.getInt(currentLayoutKey, -1)
        if (currentLayout == -1) {
            writeCurrentLayout(0)
            return 0
        }
        return currentLayout
    }

    fun writeCurrentLayout(index: Int) {
        with (sharedPref.edit()) {
            putInt(currentLayoutKey, index)
            apply()
        }
    }

    fun isHapticFeedbackEnabled(): Boolean {
        return sharedPref.getBoolean(hapticFeedbackEnabledKey, false)
    }

    fun setHapticFeedbackEnabled(enabled: Boolean) {
        with (sharedPref.edit()) {
            putBoolean(hapticFeedbackEnabledKey, enabled)
            apply()
        }
    }
}