package com.banquemisr.challenge05.data.entity.moviedetails

import com.google.gson.annotations.SerializedName


data class Genres(

    @SerializedName("id") var id: Int? = null, @SerializedName("name") var name: String? = null

)