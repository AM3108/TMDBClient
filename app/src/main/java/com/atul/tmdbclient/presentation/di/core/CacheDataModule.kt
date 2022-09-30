package com.atul.tmdbclient.presentation.di.core

import com.atul.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.atul.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.atul.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.atul.tmdbclient.data.repository.movie.datsourceimpl.MovieCacheDataSourceImpl
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowsCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}