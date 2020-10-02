package com.cassiolucianodasilva.domain.repository

import com.cassiolucianodasilva.domain.entity.Genre
import com.cassiolucianodasilva.domain.entity.MoviesEntity
import com.cassiolucianodasilva.domain.entity.MoviesItem
import com.cassiolucianodasilva.domain.entity.Response
import java.util.*

interface MoviesRepository {
    suspend fun getMovies(): Response<MoviesEntity>
    suspend fun getGenres(): Response<ArrayList<Genre>>
    suspend fun saveFavorite(movie: MoviesItem): Boolean
    suspend fun getFavoritesMovies(): MoviesEntity
}