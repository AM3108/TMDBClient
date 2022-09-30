package com.atul.tmdbclient.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.domain.usecases.GetMoviesUseCase
import com.atul.tmdbclient.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
): ViewModel() {

    fun getMovies(): LiveData<List<Movie>> = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        if (movieList != null) {
            emit(movieList)
        }
    }

    fun updateMovies(): LiveData<List<Movie>> = liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute()
        if (movieList != null) {
            emit(movieList)
        }
    }
}