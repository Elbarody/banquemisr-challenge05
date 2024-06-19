package com.banquemisr.challenge05.data.entity

import com.google.gson.annotations.SerializedName

data class MovieListItem(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName( "poster_path") val image: String
)
