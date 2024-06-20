package com.banquemisr.challenge05.data.repo.movieslist

import com.banquemisr.challenge05.data.entity.MoviesListResponse

interface MoviesListRepo {
    suspend fun getMoviesList(
        moviesType: String,
        page: Int,
    ): MoviesListResponse
}