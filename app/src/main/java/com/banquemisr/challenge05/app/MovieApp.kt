package com.banquemisr.challenge05.app

import android.app.Application

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this)
    }
}