package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("count")
    val count: Int
)