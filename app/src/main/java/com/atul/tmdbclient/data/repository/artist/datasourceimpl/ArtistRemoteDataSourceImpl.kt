package com.atul.tmdbclient.data.repository.artist.datasourceimpl

import com.atul.tmdbclient.data.api.TMDBService
import com.atul.tmdbclient.data.model.artist.ArtistList
import com.atul.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
): ArtistRemoteDataSource {
    override suspend fun getArtistListFromApi(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey = apiKey)
    }
}