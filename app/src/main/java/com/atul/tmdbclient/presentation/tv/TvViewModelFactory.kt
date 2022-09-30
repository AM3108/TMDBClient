package com.atul.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atul.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.atul.tmdbclient.domain.usecases.UpdateTvShowsUseCase

class TvViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}