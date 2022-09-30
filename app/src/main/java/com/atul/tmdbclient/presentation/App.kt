package com.atul.tmdbclient.presentation

import android.app.Application
import com.atul.tmdbclient.BuildConfig
import com.atul.tmdbclient.presentation.di.Injector
import com.atul.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.atul.tmdbclient.presentation.di.core.*
import com.atul.tmdbclient.presentation.di.movie.MovieSubComponent
import com.atul.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector{
    /*Declare variable for AppComponent
    * Then we are going to construct AppComponent in the OnCreate*/
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.moviesSubcomponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubcomponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubcomponent().create()
    }
}