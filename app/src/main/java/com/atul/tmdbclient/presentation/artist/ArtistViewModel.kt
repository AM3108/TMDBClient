package com.atul.tmdbclient.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.atul.tmdbclient.data.model.artist.Artist
import com.atul.tmdbclient.domain.usecases.GetArtistsUseCase
import com.atul.tmdbclient.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
): ViewModel() {

    fun getArtist(): LiveData<List<Artist>> = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        artistList?.let { emit(it) }
    }

    fun updateArtist(): LiveData<List<Artist>> = liveData {
        val artistList: List<Artist>? = updateArtistsUseCase.execute()
        artistList?.let { emit(it) }
    }
}