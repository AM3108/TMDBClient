package com.atul.tmdbclient.data.repository.tvshow.datasource

import com.atul.tmdbclient.data.model.tvshow.TvShow

interface TvShowsCacheDataSource {

    suspend fun getTvShowFromCache(): List<TvShow>

    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
}