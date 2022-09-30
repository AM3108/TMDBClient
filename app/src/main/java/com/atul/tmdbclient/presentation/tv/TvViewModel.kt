package com.atul.tmdbclient.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.atul.tmdbclient.data.model.tvshow.TvShow
import com.atul.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.atul.tmdbclient.domain.usecases.UpdateTvShowsUseCase

class TvViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
): ViewModel() {

    fun getTvShows(): LiveData<List<TvShow>> = liveData {
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        if (tvShowList != null) {
            emit(tvShowList)
        }
    }

    fun updateTvShows(): LiveData<List<TvShow>> = liveData {
        val tvShowList: List<TvShow>? = updateTvShowsUseCase.execute()
        if (tvShowList != null) {
            emit(tvShowList)
        }
    }
}