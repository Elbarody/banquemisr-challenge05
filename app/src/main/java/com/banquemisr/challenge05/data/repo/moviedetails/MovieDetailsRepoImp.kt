package com.banquemisr.challenge05.data.repo.moviedetails

import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import com.banquemisr.challenge05.data.remote.moviedetails.MovieDetailsRemoteDataSource

class MovieDetailsRepoImp(private val remoteDataSource: MovieDetailsRemoteDataSource) :
    MovieDetailsRepo {
    override suspend fun getMovieDetails(movieId: Int): MovieDetails =
        remoteDataSource.getMovieDetails(movieId)


}