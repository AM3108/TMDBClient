package com.atul.tmdbclient.presentation.di.artist

import com.atul.tmdbclient.presentation.artist.ArtistFragment
import dagger.Subcomponent
import javax.inject.Inject

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    /*This subcomponent has only one module.
    * We will use this subcomponent to inject dependency to artist fragment.
    * Therefore we need to define an inject fn.
    * Here keeping an instance of ArtistFragment as a parameter*/
    fun inject(artistFragment: ArtistFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ArtistSubComponent
    }
    /*We must define subcomponent factory inside ArtistSubcomponent.
    * So that AppComponent knows how to create Instances of this ArtistSubComponent*/
}

