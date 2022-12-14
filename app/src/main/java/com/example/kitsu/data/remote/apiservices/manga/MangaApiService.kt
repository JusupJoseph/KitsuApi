package com.example.kitsu.data.remote.apiservices.manga

import com.example.kitsu.models.KitsuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int = 20,
        @Query("page[offset]") offset: Int = 0
    ): Response<KitsuResponse>

    @GET("manga/{id}")
    suspend fun fetchDetailsManga(
        @Path("id") id: String
    ): Response<KitsuResponse>
}