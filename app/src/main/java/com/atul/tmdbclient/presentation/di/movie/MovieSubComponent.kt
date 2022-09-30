package com.atul.tmdbclient.presentation.di.movie

import com.atul.tmdbclient.presentation.movie.MovieFragment
import dagger.Component
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieFragment: MovieFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSubComponent
    }
}