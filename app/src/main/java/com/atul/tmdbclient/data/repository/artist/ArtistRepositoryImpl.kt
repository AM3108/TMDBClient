package com.atul.tmdbclient.data.repository.artist

import android.util.Log
import com.atul.tmdbclient.data.model.artist.Artist
import com.atul.tmdbclient.data.model.artist.ArtistList
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.atul.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList: List<Artist> = getArtistFromApi()
        artistLocalDataSource.deleteAllArtistFromDB()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtistListFromApi()
            val body: ArtistList? = response.body()
            if (body != null)
            {
                artistList = body.artists
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
          artistList = artistLocalDataSource.getArtistListFromDB()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty() && artistList.size > 0)
        {
            return artistList
        }else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty() && artistList.size > 0)
        {
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}