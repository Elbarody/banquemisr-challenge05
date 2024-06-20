package com.banquemisr.challenge05.data.remote.moviedetails

import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails

class MovieDetailsRemoteDataSourceImp(private val api: MovieDetailsApi) : MovieDetailsRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int): MovieDetails =
        api.getMovieDetails(movieId)

}