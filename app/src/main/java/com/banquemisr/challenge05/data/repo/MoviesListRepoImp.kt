package com.banquemisr.challenge05.data.repo

import com.banquemisr.challenge05.data.entity.MovieListItem
import com.banquemisr.challenge05.data.entity.MoviesListResponse
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSource
import com.banquemisr.challenge05.utility.network.RemoteConstants

class MoviesListRepoImp(private val remoteDataSource: MoviesListRemoteDataSource) : MoviesListRepo {
    override suspend fun getMoviesList(moviesType: String, page: Int): MoviesListResponse {
        val response = remoteDataSource.getMoviesList(moviesType, page)
        val modifiedMovies = response.moviesList.map { addImageUrlToMovieItem(it) }
        return MoviesListResponse(response.page, modifiedMovies, response.totalPages, response.totalResults)
    }

    private fun addImageUrlToMovieItem(movieItem: MovieListItem): MovieListItem {
        val modifiedItem = movieItem.copy(
            image = RemoteConstants.IMAGE_URL + movieItem.image
        )
        return modifiedItem
    }
}