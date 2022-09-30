package com.atul.tmdbclient.presentation.di.movie

import com.atul.tmdbclient.domain.usecases.GetMoviesUseCase
import com.atul.tmdbclient.domain.usecases.UpdateMoviesUseCase
import com.atul.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase,
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase, updateMoviesUseCase
        )
    }
}