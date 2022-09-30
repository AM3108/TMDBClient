package com.atul.tmdbclient.data.repository.movie.datasource

import com.atul.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movie: List<Movie>)
    suspend fun deleteAllFromDB()

}