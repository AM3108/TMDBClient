package com.atul.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atul.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(tvShow: List<Artist>)

    @Query(value = "DELETE FROM popular_artist")
    suspend fun deleteArtists()

    @Query(value = "SELECT * FROM popular_artist")
    suspend fun getArtists(): List<Artist>
}