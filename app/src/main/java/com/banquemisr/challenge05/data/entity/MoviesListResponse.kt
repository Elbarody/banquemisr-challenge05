package com.banquemisr.challenge05.data.entity

import com.google.gson.annotations.SerializedName


data class MoviesListResponse(
    @SerializedName("page")val page: Int,
    @SerializedName("results") val moviesList: List<MovieListItem>,
    @SerializedName("total_pages")val totalPages: Int,
    @SerializedName("total_results")val totalResults: Int
)
