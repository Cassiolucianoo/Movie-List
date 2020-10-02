package com.cassiolucianodasilva.domain.usecase

import com.cassiolucianodasilva.domain.entity.Genre
import com.cassiolucianodasilva.domain.entity.MoviesEntity
import com.cassiolucianodasilva.domain.entity.MoviesItem
import com.cassiolucianodasilva.domain.entity.Response
import java.util.*

interface MoviesUseCase {
    suspend fun getMovies(): Response<MoviesEntity>
    suspend fun getFavoritesMovies(): MoviesEntity
    suspend fun getGenres(): Response<ArrayList<Genre>>
    suspend fun saveFavorite(movie:MoviesItem): Boolean
}