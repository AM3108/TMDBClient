package com.atul.tmdbclient.data.repository.movie.datsourceimpl

import com.atul.tmdbclient.data.api.TMDBService
import com.atul.tmdbclient.data.model.movie.MovieList
import com.atul.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
): MovieRemoteDataSource {
    override suspend fun getMoviesFromRemote(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)


/*{
        return tmdbService.getPopularMovies(
            apiKey = apiKey
        )
    }*/
}