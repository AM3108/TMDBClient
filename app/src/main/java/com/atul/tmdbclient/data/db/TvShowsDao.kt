package com.atul.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atul.tmdbclient.data.model.tvshow.TvShow
@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: List<TvShow>)

    @Query(value = "DELETE FROM popular_tv")
    suspend fun deleteTvShows()

    @Query(value = "SELECT * FROM popular_tv")
    suspend fun getTvShows(): List<TvShow>
}