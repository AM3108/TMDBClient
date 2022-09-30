package com.atul.tmdbclient.presentation.di.tvshow

import com.atul.tmdbclient.domain.usecases.GetTvShowsUseCase
import com.atul.tmdbclient.domain.usecases.UpdateTvShowsUseCase
import com.atul.tmdbclient.presentation.tv.TvViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase,
    ): TvViewModelFactory {
        return TvViewModelFactory(
            getTvShowsUseCase, updateTvShowsUseCase
        )
    }
}