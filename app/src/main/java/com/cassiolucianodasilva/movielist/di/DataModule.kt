package com.cassiolucianodasilva.movielist.di

import com.cassiolucianodasilva.data.client.ApiClient.makeService
import com.cassiolucianodasilva.data.source.remote.MoviesDataSource
import com.cassiolucianodasilva.data.source.remote.MoviesDataSourceImpl
import com.cassiolucianodasilva.data.source.remote.service.MoviesService
import com.cassiolucianodasilva.data.repository.MoviesRepositoryImpl
import com.cassiolucianodasilva.data.source.local.FavoritesDataSource
import com.cassiolucianodasilva.data.source.local.FavoritesDataSourceImpl
import com.cassiolucianodasilva.domain.repository.MoviesRepository
import org.koin.dsl.module

object DataModule {
    val serviceModules = module {
        single { makeService<MoviesService>() }
    }

    val dataModules = module {

        single<MoviesDataSource> {
            MoviesDataSourceImpl(get(), get())
        }
        single<FavoritesDataSource> {
            FavoritesDataSourceImpl(get())
        }
        single<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }
    }

}