package com.atul.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atul.tmdbclient.data.model.artist.Artist
import com.atul.tmdbclient.data.model.movie.Movie
import com.atul.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun moviesDao(): MovieDao
    abstract fun tvShowDao(): TvShowsDao
    abstract fun artistDao(): ArtistDao
}