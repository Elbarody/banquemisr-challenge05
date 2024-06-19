package com.banquemisr.challenge05.data.repo

import com.banquemisr.challenge05.data.entity.MoviesListResponse

interface MoviesListRepo {
    suspend fun getMoviesList(
        moviesType: String,
        page: Int,
    ): MoviesListResponse
}