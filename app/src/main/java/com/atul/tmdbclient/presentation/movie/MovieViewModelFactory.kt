package com.atul.tmdbclient.presentation.movie


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atul.tmdbclient.domain.usecases.GetMoviesUseCase
import com.atul.tmdbclient.domain.usecases.UpdateMoviesUseCase


class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}