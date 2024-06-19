package com.banquemisr.challenge05.data.remote.movieList

import com.banquemisr.challenge05.BuildConfig
import com.banquemisr.challenge05.data.entity.MoviesListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesListApi {
    @GET("movie/{movies_list_type}")
    suspend fun getMoviesList(
        @Path("movies_list_type") moviesType: String,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("page") page: Int,
    ): MoviesListResponse

}