package com.atul.tmdbclient.data.repository.tvshow.datasourceimpl

import com.atul.tmdbclient.data.model.tvshow.TvShow
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsCacheDataSource

class TvShowCacheDataSourceImpl(): TvShowsCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}