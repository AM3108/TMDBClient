package com.atul.tmdbclient.data.repository.artist.datasource

import com.atul.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtistListFromApi(): Response<ArtistList>
}