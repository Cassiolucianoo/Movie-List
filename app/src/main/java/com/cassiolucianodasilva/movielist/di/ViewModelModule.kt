package com.cassiolucianodasilva.movielist.di

import com.cassiolucianodasilva.movielist.presentation.MainViewModel
import com.cassiolucianodasilva.movielist.presentation.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val viewModelModules = module {
        viewModel { MainViewModel(get()) }
        viewModel { DetailViewModel(get()) }
    }
}