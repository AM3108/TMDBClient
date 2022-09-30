package com.atul.tmdbclient.presentation.di.core

import com.atul.tmdbclient.data.api.TMDBService
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.atul.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.atul.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.atul.tmdbclient.data.repository.movie.datsourceimpl.MovieRemoteDataSourceImpl
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}