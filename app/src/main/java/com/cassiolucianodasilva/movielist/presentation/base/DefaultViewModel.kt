package com.cassiolucianodasilva.movielist.presentation.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.KoinComponent

open class DefaultViewModel : ViewModel(), LifecycleObserver, KoinComponent{
    val uiScope = CoroutineScope(Dispatchers.Main)
}