package com.cassiolucianodasilva.data.repository

import com.cassiolucianodasilva.data.source.local.FavoritesDataSource
import com.cassiolucianodasilva.data.source.remote.MoviesDataSource
import com.cassiolucianodasilva.domain.entity.Genre
import com.cassiolucianodasilva.domain.entity.MoviesEntity
import com.cassiolucianodasilva.domain.entity.MoviesItem
import com.cassiolucianodasilva.domain.entity.Response
import com.cassiolucianodasilva.domain.repository.MoviesRepository
import java.util.*

class MoviesRepositoryImpl(
    private val moviesDataSource: MoviesDataSource,
    private val favoritesDataSource: FavoritesDataSource
) : MoviesRepository {
    override suspend fun getFavoritesMovies(): MoviesEntity {
        return favoritesDataSource.getFavorites()
    }

    override suspend fun saveFavorite(movie: MoviesItem): Boolean {
        return favoritesDataSource.saveFavorite(movie)
    }

    override suspend fun getMovies(): Response<MoviesEntity> {
        return moviesDataSource.getMovies()
    }

    override suspend fun getGenres(): Response<ArrayList<Genre>> {
        return moviesDataSource.getGenres()
    }

}