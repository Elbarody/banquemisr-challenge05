package com.banquemisr.challenge05.data.remote.moviedetails

import com.banquemisr.challenge05.BuildConfig
import com.banquemisr.challenge05.data.entity.MoviesListResponse
import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
    ): MovieDetails

}