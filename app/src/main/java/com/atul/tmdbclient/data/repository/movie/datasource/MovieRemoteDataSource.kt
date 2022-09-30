package com.atul.tmdbclient.data.repository.movie.datasource

import com.atul.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMoviesFromRemote(): Response<MovieList>
}