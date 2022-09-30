package com.atul.tmdbclient.domain.usecases

import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.domain.repository.MovieRepository

/*Inside these class we have to write fun which return the List of Movies instance.
* But a UseCase class cannot do it without support of repository.
* So we need a repository which return instances of list of movies.
* We would able to inject the instance of repository to the use case class as a constructor parameter*/

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    /*Now we will create execute fun of this use case*/
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
    /*Now viewModel class can call this fun to get list of movies.*/

}