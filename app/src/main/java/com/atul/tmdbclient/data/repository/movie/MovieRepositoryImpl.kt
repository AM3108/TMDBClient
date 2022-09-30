package com.atul.tmdbclient.data.repository.movie

import android.util.Log
import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.data.model.movie.MovieList
import com.atul.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.atul.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.atul.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.atul.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        /*This fun will return  list of movie instances*/
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        /*This fun will update the DB of popular_movies taken from API and return new list of movie instance*/
        val newMoviesList: List<Movie> = getMoviesFromApi()
        movieLocalDataSource.deleteAllFromDB()
        movieLocalDataSource.saveMoviesToDB(newMoviesList)
        movieCacheDataSource.saveMoviesToCache(newMoviesList)
        return newMoviesList
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
           val response: Response<MovieList> = movieRemoteDataSource.getMoviesFromRemote()
           val body: MovieList? = response.body()
            if(body != null)
            {
                movieList = body.movies!!
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromLocalDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
          movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception: Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if(movieList.isNotEmpty() && movieList.size > 0) {
            return movieList
        }else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(movieList.isNotEmpty() && movieList.size > 0)
        {
            return movieList
        }else{
            movieList = getMoviesFromLocalDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}