package com.tenextractor.redefinablekeyboard.common.data

import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout

interface KbLayoutStorage {
    suspend fun getAllLayoutNames(): Array<String>
    suspend fun getLayout(name: String): KbLayout
    suspend fun createLayout(name: String): Boolean
    /* ^ should fail if there is already a layout with the given name, including inbuilt layouts */
    suspend fun updateLayout(name: String, newKbLayout: KbLayout)
    suspend fun deleteLayout(name: String)
}