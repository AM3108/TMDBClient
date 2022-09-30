package com.atul.tmdbclient.data.repository.artist.datasource

import com.atul.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistListFromDB(): List<Artist>

    suspend fun deleteAllArtistFromDB()

    suspend fun saveArtistToDB(artist: List<Artist>)
}