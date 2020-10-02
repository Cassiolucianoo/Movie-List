package com.cassiolucianodasilva.data.mapper

import com.cassiolucianodasilva.data.model.MoviesResponse
import com.cassiolucianodasilva.domain.entity.MoviesEntity
import com.cassiolucianodasilva.domain.entity.MoviesItem

class MoviesResponseToMoviesMapper : Mapper<MoviesResponse, MoviesEntity>() {
    override fun transform(item: MoviesResponse?) =
        MoviesEntity(
            page = item?.page ?: 0,
            totalPages = item?.totalPages ?: 0,
            totalResults = item?.totalResults ?: 0,
            movies = item?.results?.map { MoviesItemResponseToMoviesItemMapper().transform(it) } as? ArrayList<MoviesItem?>
                ?: arrayListOf())


}