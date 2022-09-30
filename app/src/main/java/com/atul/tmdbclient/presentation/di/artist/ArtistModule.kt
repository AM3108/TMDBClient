package com.atul.tmdbclient.presentation.di.artist

import com.atul.tmdbclient.domain.usecases.GetArtistsUseCase
import com.atul.tmdbclient.domain.usecases.UpdateArtistsUseCase
import com.atul.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase,
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}