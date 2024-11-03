package com.tenextractor.redefinablekeyboard.common.data
/*
import android.content.Context
import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class LayoutLocalStorage @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val gson: Gson
) : KbLayoutStorage {
    override suspend fun getAllLayoutNames(): Array<String> {
        return this.appContext.fileList()
    }

    override suspend fun getLayout(name: String): KbLayout {
        if (name == "") {
            throw IllegalArgumentException("Empty filename")
        }
        val fileContent = this.appContext.openFileInput(name).bufferedReader().use {it.readText()}
        return this.gson.fromJson(fileContent, KbLayout::class.java)
    }

    override suspend fun createLayout(name: String): Boolean {
        if (name == "") {
            throw IllegalArgumentException("Empty filename")
        }
        val result = File(this.appContext.filesDir, name).createNewFile()
        return if (!result) false
        else {
            updateLayout(name, KbLayout(name = name, layers = emptyList()))
            true
        }
    }

    override suspend fun updateLayout(name: String, newKbLayout: KbLayout) {
        if (name == "") {
            throw IllegalArgumentException("Empty filename")
        }
        val json = this.gson.toJson(newKbLayout)
        this.appContext.openFileOutput(name, Context.MODE_PRIVATE).use {it.write(json.toByteArray())}
    }

    override suspend fun deleteLayout(name: String) {
        if (name == "") {
            throw IllegalArgumentException("Empty filename")
        }
        try {
            File(this.appContext.filesDir, name).delete()
        } catch (e: Exception) {
            println("delete layout failed")
            e.printStackTrace()
        }
    }
}*/