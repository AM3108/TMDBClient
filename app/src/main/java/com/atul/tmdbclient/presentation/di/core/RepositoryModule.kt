package com.atul.tmdbclient.presentation.di.core

import com.atul.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.atul.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.atul.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.atul.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.atul.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.atul.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.atul.tmdbclient.domain.repository.ArtistRepository
import com.atul.tmdbclient.domain.repository.MovieRepository
import com.atul.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowsRemoteDataSource: TvShowRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource,
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowsRemoteDataSource,
            tvShowsLocalDataSource,
            tvShowsCacheDataSource,
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource,
        )
    }
}