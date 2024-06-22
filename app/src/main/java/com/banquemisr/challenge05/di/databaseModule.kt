package com.banquemisr.challenge05.di

import androidx.room.Room
import com.banquemisr.challenge05.data.local.MoviesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), MoviesDatabase::class.java, "movies_database.db")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<MoviesDatabase>().popularMoviesDao() }
    single { get<MoviesDatabase>().upcomingMoviesDao() }
    single { get<MoviesDatabase>().nowPlayingMoviesDao() }
}