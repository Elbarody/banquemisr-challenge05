package com.banquemisr.challenge05.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PopularMoviesDao::class, UpcomingMoviesDao::class, NowPlayingMoviesDao::class],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun nowPlayingMoviesDao(): NowPlayingMoviesDao
    abstract fun upcomingMoviesDao(): UpcomingMoviesDao
    abstract fun popularMoviesDao(): PopularMoviesDao
}