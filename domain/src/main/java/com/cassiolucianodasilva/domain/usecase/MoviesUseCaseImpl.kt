package com.cassiolucianodasilva.domain.usecase

import com.cassiolucianodasilva.domain.entity.*
import com.cassiolucianodasilva.domain.repository.MoviesRepository
import java.util.*

class MoviesUseCaseImpl(private val moviesRepository: MoviesRepository) : MoviesUseCase {

    override suspend fun getMovies(): Response<MoviesEntity> {
        return moviesRepository.getMovies()
    }

    override suspend fun getFavoritesMovies(): MoviesEntity {
        return moviesRepository.getFavoritesMovies()
    }

    override suspend fun getGenres(): Response<ArrayList<Genre>> {
        return moviesRepository.getGenres()
    }

    override suspend fun saveFavorite(movie: MoviesItem): Boolean{
            return moviesRepository.saveFavorite(movie)
    }
}