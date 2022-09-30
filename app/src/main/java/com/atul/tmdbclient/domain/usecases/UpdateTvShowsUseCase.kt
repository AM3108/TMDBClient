package com.atul.tmdbclient.domain.usecases

import com.atul.tmdbclient.data.model.tvshow.TvShow
import com.atul.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}