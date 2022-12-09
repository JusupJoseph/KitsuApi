package com.example.kitsu.models

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("abbreviatedTitles")
    val abbreviatedTitles: List<String>,
    @SerializedName("ageRating")
    val ageRating: String,
    @SerializedName("ageRatingGuide")
    val ageRatingGuide: String,
    @SerializedName("averageRating")
    val averageRating: String,
    @SerializedName("canonicalTitle")
    val canonicalTitle: String,
    @SerializedName("chapterCount")
    val chapterCount: Int,
    @SerializedName("coverImage")
    val coverImage: CoverImage,
    @SerializedName("coverImageTopOffset")
    val coverImageTopOffset: Int,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("endDate")
    val endDate: String,
    @SerializedName("favoritesCount")
    val favoritesCount: Int,
    @SerializedName("mangaType")
    val mangaType: String,
    @SerializedName("nextRelease")
    val nextRelease: Any,
    @SerializedName("popularityRank")
    val popularityRank: Int,
    @SerializedName("posterImage")
    val posterImage: PosterImage,
    @SerializedName("ratingFrequencies")
    val ratingFrequencies: RatingFrequencies,
    @SerializedName("ratingRank")
    val ratingRank: Int,
    @SerializedName("serialization")
    val serialization: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("startDate")
    val startDate: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("subtype")
    val subtype: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("tba")
    val tba: String,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userCount")
    val userCount: Int,
    @SerializedName("volumeCount")
    val volumeCount: Int
)