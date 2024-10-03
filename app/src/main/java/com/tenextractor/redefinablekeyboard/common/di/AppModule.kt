package com.tenextractor.redefinablekeyboard.common.di

import android.content.Context
import com.google.gson.Gson
import com.tenextractor.redefinablekeyboard.common.data.KbLayoutStorage
import com.tenextractor.redefinablekeyboard.common.data.LayoutLocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideLayoutStorage(@ApplicationContext appContext: Context, gson: Gson): KbLayoutStorage {
        return LayoutLocalStorage(appContext, gson)
    }
}