package com.example.kitsu.models.manga

import com.example.kitsu.models.Links
import com.example.kitsu.models.Meta
import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("data")
    val result: List<MangaModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)