package com.banquemisr.challenge05.app.mainkoinmodule

import android.app.Application
import com.banquemisr.challenge05.di.remoteModule
import org.koin.core.logger.Level
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun startKoin(application: Application) {
    startKoin {
        androidContext(application)
        printLogger(Level.NONE)
        modules(
            listOf(
                remoteModule
            )
        )
    }
}