package com.banquemisr.challenge05.data.entity.moviedetails

import com.google.gson.annotations.SerializedName


data class ProductionCompanies(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("logo_path") var logoPath: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("origin_country") var originCountry: String? = null

)