package com.atul.tmdbclient.data.repository.tvshow.datasource

import com.atul.tmdbclient.data.model.tvshow.TvShow
import com.atul.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShowsFromApi(): Response<TvShowList>
}