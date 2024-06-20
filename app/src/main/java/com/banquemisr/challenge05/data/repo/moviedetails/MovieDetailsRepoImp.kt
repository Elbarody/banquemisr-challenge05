package com.banquemisr.challenge05.data.repo.moviedetails

import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import com.banquemisr.challenge05.data.remote.moviedetails.MovieDetailsRemoteDataSource
import com.banquemisr.challenge05.utility.network.RemoteConstants

class MovieDetailsRepoImp(private val remoteDataSource: MovieDetailsRemoteDataSource) :
    MovieDetailsRepo {
    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        val response = remoteDataSource.getMovieDetails(movieId)
        val moviePosterFullUrl = RemoteConstants.IMAGE_URL + response.posterPath
        return response.copy(posterPath = moviePosterFullUrl)
    }

}