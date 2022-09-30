package com.atul.tmdbclient.data.repository.movie.datsourceimpl

import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl(): MovieCacheDataSource {
    /*In this class we will create an Array list of movie instance.
    *Then whenever user launches app first time & load data we will assign that list with this array list.
    *We will keep this MovieCacheDataSourceImpl instance which holds the arraylist as singleton using dagger.
    *So if the user load movie data again instead of using DB we can use cache list.
    * Now I am declaring array list of movies. */

    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movie: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movie)
    }
}