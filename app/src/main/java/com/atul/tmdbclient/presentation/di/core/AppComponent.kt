package com.atul.tmdbclient.presentation.di.core

import com.atul.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.atul.tmdbclient.presentation.di.movie.MovieSubComponent
import com.atul.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
CacheDataModule::class,
DataBaseModule::class,
LocalDataModule::class,
NetworkModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCaseModule::class,
])
interface AppComponent {

    fun moviesSubcomponent(): MovieSubComponent.Factory
    fun tvShowSubcomponent(): TvShowSubComponent.Factory
    fun artistSubcomponent(): ArtistSubComponent.Factory

}