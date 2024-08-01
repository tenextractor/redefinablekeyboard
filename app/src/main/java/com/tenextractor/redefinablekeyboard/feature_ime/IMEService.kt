package com.tenextractor.redefinablekeyboard.feature_ime

import android.content.Intent
import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.lifecycle.setViewTreeViewModelStoreOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
/*
class IMEService : InputMethodService(), LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    private val store = ViewModelStore()
    private val savedStateRegistryController = SavedStateRegistryController.create(this)
    protected val dispatcher = ServiceLifecycleDispatcher(this)
    private lateinit var viewModel: KeyboardViewModel
    override val savedStateRegistry: SavedStateRegistry get() = savedStateRegistryController.savedStateRegistry
    override val lifecycle: Lifecycle
        get() {
            return dispatcher.lifecycle
        }
    override val viewModelStore: ViewModelStore
        get() {
            return store
        }

    @CallSuper
    override fun onCreate() {
        dispatcher.onServicePreSuperOnCreate()
        super.onCreate()
        savedStateRegistryController.performRestore(null)
        viewModel = ViewModelProvider(this)[KeyboardViewModel::class]
    }

    override fun onCreateInputView(): View {
        val view = KeyboardView(this, /*viewModel*/)

        window?.window?.decorView?.let { decorView ->
            decorView.setViewTreeLifecycleOwner(this)
            decorView.setViewTreeViewModelStoreOwner(this)
            decorView.setViewTreeSavedStateRegistryOwner(this)
        }
        return view
    }

    @CallSuper
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    @CallSuper
    override fun onDestroy() {
        dispatcher.onServicePreSuperOnDestroy()
        super.onDestroy()
    }

    override fun onStartInputView(editorInfo: EditorInfo?, restarting: Boolean) {
        setInputView(onCreateInputView())
    }
}*/