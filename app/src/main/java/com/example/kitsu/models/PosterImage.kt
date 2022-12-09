package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("large")
    val large: String,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("original")
    val original: String
)