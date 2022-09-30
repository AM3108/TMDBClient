package com.atul.tmdbclient.data.repository.tvshow.datasourceimpl

import com.atul.tmdbclient.data.db.TvShowsDao
import com.atul.tmdbclient.data.model.tvshow.TvShow
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    private val tvShowsDao: TvShowsDao
): TvShowsLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun deleteAllTvShowsFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteTvShows()
        }
    }

    override suspend fun saveTvShowsToDB(tvShow: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShow)
        }
    }
}