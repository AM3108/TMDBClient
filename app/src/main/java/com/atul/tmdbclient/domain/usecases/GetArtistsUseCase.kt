package com.atul.tmdbclient.domain.usecases

import com.atul.tmdbclient.data.model.artist.Artist
import com.atul.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}