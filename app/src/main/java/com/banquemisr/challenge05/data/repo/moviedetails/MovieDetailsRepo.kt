package com.banquemisr.challenge05.data.repo.moviedetails

import com.banquemisr.challenge05.data.entity.MoviesListResponse
import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails

interface MovieDetailsRepo {
    suspend fun getMovieDetails(
        movieId: Int,
    ): MovieDetails
}