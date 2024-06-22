package com.banquemisr.challenge05.data.remote.moviedetails

import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import com.banquemisr.challenge05.utility.network.RemoteConstants

class MovieDetailsRemoteDataSourceImp(private val api: MovieDetailsApi) : MovieDetailsRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val response = api.getMovieDetails(movieId)
        val moviePosterFullUrl = RemoteConstants.IMAGE_URL + response.posterPath
        return response.copy(posterPath = moviePosterFullUrl)
    }

}