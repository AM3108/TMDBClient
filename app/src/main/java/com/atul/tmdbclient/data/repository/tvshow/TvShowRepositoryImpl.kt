package com.atul.tmdbclient.data.repository.tvshow

import android.util.Log
import com.atul.tmdbclient.data.model.tvshow.TvShow
import com.atul.tmdbclient.data.model.tvshow.TvShowList
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsCacheDataSource
import com.atul.tmdbclient.data.repository.tvshow.datasource.TvShowsLocalDataSource
import com.atul.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource,
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList: List<TvShow> = getTvShowsFromApi()
        tvShowsLocalDataSource.deleteAllTvShowsFromDB()
        tvShowsLocalDataSource.saveTvShowsToDB(newTvShowList)
        tvShowsCacheDataSource.saveTvShowToCache(newTvShowList)
        return newTvShowList
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {

        lateinit var tvShowsList: List<TvShow>

        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getTvShowsFromApi()
            val body: TvShowList? = response.body()
            if(body != null)
            {
                tvShowsList = body.tvShow!!
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowsList
    }

    suspend fun getTvShowsFromLocalDB(): List<TvShow> {

        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowsLocalDataSource.getTvShowsFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if(tvShowList.isNotEmpty() && tvShowList.size > 0)
        {
            return tvShowList
        }else{
            tvShowList = getTvShowsFromApi()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowsCacheDataSource.getTvShowFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if(tvShowList.isNotEmpty() && tvShowList.size > 0)
        {
            return tvShowList
        }else{
            tvShowList = getTvShowsFromLocalDB()
            tvShowsCacheDataSource.saveTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}