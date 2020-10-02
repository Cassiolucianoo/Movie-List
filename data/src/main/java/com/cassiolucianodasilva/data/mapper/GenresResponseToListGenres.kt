package com.cassiolucianodasilva.data.mapper

import com.cassiolucianodasilva.data.model.GenresResponse
import com.cassiolucianodasilva.domain.entity.Genre

class GenresResponseToListGenres : Mapper<GenresResponse, ArrayList<Genre>>() {
    override fun transform(item: GenresResponse?): ArrayList<Genre> {
        val array = ArrayList<Genre>()
        item?.genres?.forEach {
            array.add(Genre(it?.name.orEmpty(), it?.id ?: 0))
        }
        return array
    }
}