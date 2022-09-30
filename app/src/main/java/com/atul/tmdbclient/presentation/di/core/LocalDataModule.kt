package com.atul.tmdbclient.presentation.di.core

import com.atul.tmdbclient.data.api.TMDBService
import com.atul.tmdbclient.data.db.ArtistDao
import com.atul.tmdbclient.data.db.MovieDao
import com.atul.tmdbclient.data.db.TvShowsDao
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.atul.tmdbclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.atul.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.atul.tmdbclient.data.repository.movie.datsourceimpl.MovieLocalDataSourceImpl
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {
/* We have already created LocalDataModule to provide DAO Dependency*/
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(
            movieDao = movieDao
        )
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowsDao: TvShowsDao): TvShowsLocalDataSource {
        return TvShowLocalDataSourceImpl(
            tvShowsDao = tvShowsDao
        )
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(
            artistDao
        )
    }
}