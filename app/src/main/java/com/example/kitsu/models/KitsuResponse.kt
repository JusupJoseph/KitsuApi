package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class KitsuResponse(
    @SerializedName("data")
    val result: List<KitsuModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)