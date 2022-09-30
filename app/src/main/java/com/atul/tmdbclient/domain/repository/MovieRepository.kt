package com.atul.tmdbclient.domain.repository

import com.atul.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
    /*The implementation class of these Interface will implement this fun.
    * Our useCase class don't need to know about the implementation*/
}