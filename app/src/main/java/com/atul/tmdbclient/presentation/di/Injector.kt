package com.atul.tmdbclient.presentation.di

import com.atul.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.atul.tmdbclient.presentation.di.movie.MovieSubComponent
import com.atul.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}