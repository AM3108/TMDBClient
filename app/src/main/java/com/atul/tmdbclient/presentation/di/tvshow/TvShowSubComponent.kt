package com.atul.tmdbclient.presentation.di.tvshow

import com.atul.tmdbclient.presentation.movie.MovieFragment
import com.atul.tmdbclient.presentation.tv.TvFragment
import dagger.Component
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowFragment: TvFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}