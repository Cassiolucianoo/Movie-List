package com.cassiolucianodasilva.movielist.di

import com.cassiolucianodasilva.domain.usecase.MoviesUseCase
import com.cassiolucianodasilva.domain.usecase.MoviesUseCaseImpl
import org.koin.dsl.module

object DomainModule {
    val domainModules = module {
        single<MoviesUseCase> { MoviesUseCaseImpl(get()) }
    }
}