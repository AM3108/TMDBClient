package com.atul.tmdbclient.data.repository.artist.datasourceimpl

import com.atul.tmdbclient.data.db.ArtistDao
import com.atul.tmdbclient.data.model.artist.Artist
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {

    override suspend fun getArtistListFromDB(): List<Artist> {
       return artistDao.getArtists()
    }

    override suspend fun deleteAllArtistFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtists()
        }
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artist)
        }
    }
}