package com.atul.tmdbclient.data.repository.tvshow.datasource

import com.atul.tmdbclient.data.model.tvshow.TvShow

interface TvShowsLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>

    suspend fun deleteAllTvShowsFromDB()

    suspend fun saveTvShowsToDB(tvShow: List<TvShow>)
}