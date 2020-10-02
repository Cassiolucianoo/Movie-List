package com.cassiolucianodasilva.movielist.di

import com.cassiolucianodasilva.movielist.di.DataModule.dataModules
import com.cassiolucianodasilva.movielist.di.DataModule.serviceModules
import com.cassiolucianodasilva.movielist.di.DomainModule.domainModules
import com.cassiolucianodasilva.movielist.di.ViewModelModule.viewModelModules
import org.koin.core.module.Module

object AppComponent {

    fun getAllModules(): List<Module> =
        listOf(*getViewModelModules(), *getDomainModules(), *getDataModules())

    private fun getViewModelModules(): Array<Module> {
        return arrayOf(viewModelModules)
    }

    private fun getDomainModules(): Array<Module> {
        return arrayOf(domainModules)
    }

    private fun getDataModules(): Array<Module> {
        return arrayOf(serviceModules, dataModules)
    }
}