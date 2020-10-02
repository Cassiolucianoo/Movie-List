package com.cassiolucianodasilva.data.source.remote

import android.content.Context
import com.cassiolucianodasilva.data.client.formatResponse
import com.cassiolucianodasilva.data.client.isNetworkConnected
import com.cassiolucianodasilva.data.mapper.GenresResponseToListGenres
import com.cassiolucianodasilva.data.mapper.MoviesResponseToMoviesMapper
import com.cassiolucianodasilva.data.source.remote.service.MoviesService
import com.cassiolucianodasilva.data.util.Constants
import com.cassiolucianodasilva.domain.entity.*

class MoviesDataSourceImpl(
    private val context: Context,
    private val moviesService: MoviesService
) : MoviesDataSource {
    override suspend fun getMovies(): Response<MoviesEntity> {
        if (!context.isNetworkConnected()) return ErrorResponse(
            RequestError(
                1,
                "Connection failed"
            )
        )
        return moviesService.getMovies(Constants.API_KEY).await()
            .formatResponse(MoviesResponseToMoviesMapper())
    }

    override suspend fun getGenres(): Response<ArrayList<Genre>> {
        if (!context.isNetworkConnected()) return ErrorResponse(
            RequestError(
                1,
                "Connection failed"
            )
        )
        return moviesService.getGenres(Constants.API_KEY).await()
            .formatResponse(GenresResponseToListGenres())
    }

}