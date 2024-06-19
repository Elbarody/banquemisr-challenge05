package com.banquemisr.challenge05.data.remote.movieList

import com.banquemisr.challenge05.data.entity.MoviesListResponse

class MoviesListRemoteDataSourceImp(private val api: MoviesListApi) : MoviesListRemoteDataSource {
    override suspend fun getMoviesList(moviesType: String, page: Int): MoviesListResponse =
        api.getMoviesList(moviesType = moviesType, page =  page)

}