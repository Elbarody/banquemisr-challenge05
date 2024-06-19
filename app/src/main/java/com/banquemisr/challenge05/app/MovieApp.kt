package com.banquemisr.challenge05.app

import android.app.Application
import com.banquemisr.challenge05.app.mainkoinmodule.startKoin

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this)
    }
}