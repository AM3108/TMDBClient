package com.atul.tmdbclient.data.repository.movie.datsourceimpl

import com.atul.tmdbclient.data.db.MovieDao
import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        /* when we are getting data from room db the room executes query in background thread.
        * So we don't have to explicitly write code to perform background process.*/
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        /*But we need to invoke other Dao fun for background processing
        * So we will use coroutine*/
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun deleteAllFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}