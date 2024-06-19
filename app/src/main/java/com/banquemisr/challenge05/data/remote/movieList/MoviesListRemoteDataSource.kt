package com.banquemisr.challenge05.data.remote.movieList

import com.banquemisr.challenge05.data.entity.MoviesListResponse

interface MoviesListRemoteDataSource {
    suspend fun getMoviesList(
        moviesType: String,
        page: Int,
    ): MoviesListResponse
}