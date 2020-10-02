package com.cassiolucianodasilva.movielist.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cassiolucianodasilva.domain.entity.ErrorResponse
import com.cassiolucianodasilva.domain.entity.MoviesItem
import com.cassiolucianodasilva.domain.entity.SuccessResponse
import com.cassiolucianodasilva.domain.usecase.MoviesUseCase
import com.cassiolucianodasilva.movielist.presentation.base.DefaultViewModel
import kotlinx.coroutines.launch

class DetailViewModel(private val moviesUseCase: MoviesUseCase) : DefaultViewModel() {

    var model: MoviesItem? = null

    val success: LiveData<String> get() = _success
    val loading: LiveData<Boolean> get() = _loading
    val error: LiveData<String> get() = _error
    val update: LiveData<Boolean> get() = _update

    private val _success: MutableLiveData<String> = MutableLiveData()
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    private val _error: MutableLiveData<String> = MutableLiveData()
    private val _update: MutableLiveData<Boolean> = MutableLiveData()

    private var genreIdsText = ""

    fun favoriteMovie(movie: MoviesItem?) {
        if (movie != null) {
            uiScope.launch {
                movie.isFavorite = !movie.isFavorite
                moviesUseCase.saveFavorite(movie)
                _update.postValue(movie.isFavorite)
            }
        }
    }

    fun fetchGenres() {
        _loading.postValue(true)
        uiScope.launch {
            when (val value = moviesUseCase.getGenres()) {
                is SuccessResponse -> {
                    val list = value.body.filter { model?.genreIds?.contains(it.id) ?: false }
                    list.forEach {
                        genreIdsText += " - ${it.name}"
                    }
                    genreIdsText = genreIdsText?.substring(2) ?: ""
                    _success.postValue(genreIdsText)
                    _loading.postValue(false)
                }
                is ErrorResponse -> {
                    _loading.postValue(false)
                    _error.postValue(value.error.message)
                }
            }
        }
    }
}