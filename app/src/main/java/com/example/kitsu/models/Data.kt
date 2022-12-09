package com.example.kitsu.models

data class Data(
    val attributes: Attributes,
    val id: String,
    val links: Links,
    val relationships: Relationships,
    val type: String
)