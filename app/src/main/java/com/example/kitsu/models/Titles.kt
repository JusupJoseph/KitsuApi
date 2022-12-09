package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class Titles(
    @SerializedName("en")
    val en: String,
    @SerializedName("en_jp")
    val en_jp: String,
    @SerializedName("ja_jp")
    val ja_jp: String
)