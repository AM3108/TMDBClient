package com.atul.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atul.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // It will replace our old data to new data.
    suspend fun saveMovies(movies: List<Movie>)

    @Query(value = "DELETE FROM popular_movie")
    suspend fun deleteAllMovies()

    @Query(value = "SELECT * FROM popular_movie")
    suspend fun getMovies(): List<Movie>
}