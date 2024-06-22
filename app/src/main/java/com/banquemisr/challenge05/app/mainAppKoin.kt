package com.banquemisr.challenge05.app

import android.app.Application
import com.banquemisr.challenge05.di.databaseModule
import com.banquemisr.challenge05.di.mediatorModule
import com.banquemisr.challenge05.di.movieDetailsModule
import com.banquemisr.challenge05.di.moviesListModule
import com.banquemisr.challenge05.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

fun startKoin(application: Application) {
    startKoin {
        androidContext(application)
        printLogger(Level.INFO)
        modules(
            listOf(
                remoteModule,
                databaseModule,
                mediatorModule,
                moviesListModule,
                movieDetailsModule
            )
        )
    }
}