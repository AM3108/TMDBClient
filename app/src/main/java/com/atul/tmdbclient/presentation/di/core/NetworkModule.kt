package com.atul.tmdbclient.presentation.di.core

import com.atul.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/*This module provides 2 Instance
* a) Retrofit Instance
* b) TMDB Service Instance*/
@Module
class NetworkModule(private val baseUrl: String) {
    //We should always annotate with provide otherwise dagger will not recognized it as provide function.
    //This annotation tells dagger these fn provide end object of the return data type
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService{
        return retrofit.create(TMDBService::class.java)
    }
}