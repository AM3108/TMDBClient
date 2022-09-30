package com.atul.tmdbclient.data.repository.tvshow.datasourceimpl

import com.atul.tmdbclient.data.api.TMDBService
import com.atul.tmdbclient.data.model.tvshow.TvShowList
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
): TvShowRemoteDataSource {
    override suspend fun getTvShowsFromApi(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(
            apiKey = apiKey)
    }
}