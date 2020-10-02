package com.cassiolucianodasilva.data.source.local

import com.cassiolucianodasilva.domain.entity.MoviesEntity
import com.cassiolucianodasilva.domain.entity.MoviesItem

interface FavoritesDataSource {
    suspend fun getFavorites():MoviesEntity
    suspend fun saveFavorite(item: MoviesItem):Boolean
}