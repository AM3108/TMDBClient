package com.atul.tmdbclient.domain.usecases

import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}