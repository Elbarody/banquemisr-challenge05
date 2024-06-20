package com.banquemisr.challenge05.data.remote.moviedetails

import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails

interface MovieDetailsRemoteDataSource {
    suspend fun getMovieDetails(
        movieId: Int,
    ): MovieDetails
}