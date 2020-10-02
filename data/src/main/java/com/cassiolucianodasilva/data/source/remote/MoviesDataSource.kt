package com.cassiolucianodasilva.data.source.remote

import com.cassiolucianodasilva.domain.entity.Genre
import com.cassiolucianodasilva.domain.entity.MoviesEntity
import com.cassiolucianodasilva.domain.entity.Response

interface MoviesDataSource {
    suspend fun getMovies(): Response<MoviesEntity>
    suspend fun getGenres(): Response<ArrayList<Genre>>
}