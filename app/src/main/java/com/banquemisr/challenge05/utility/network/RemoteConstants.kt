package com.banquemisr.challenge05.utility.network

import org.koin.core.component.KoinComponent

object RemoteConstants : KoinComponent {

    fun getBaseUrl(): String {
        return BASE_URL
    }

    const val CONNECT_TIMEOUT: Long = 30
    const val READ_TIMEOUT: Long = 30
    const val WRITE_TIMEOUT: Long = 30
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    const val API_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiNmNkMTM0ZDQ1YzFlM2U4MTMxMGEzYzQwNWI0NjIzYiIsInN1YiI6IjU2YTBkMzAyOTI1MTQxNWU1ZTAwZDk3OSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2hJ5Wihaqdy5tPvMJ6Dcs8xLugmJYLzfYX96s-aNDbk"
    //header constant
    object HeadersConst{
        const val ACCEPT = "Accept"
        const val AUTHORIZATION = "Authorization"
    }
}