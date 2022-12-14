package com.example.kitsu.data.repositories

import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.anime.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun fetchAnime(limit: Int, offset: Int) = doRequest {
        service.fetchAnime(limit, offset)
    }
    fun fetchDetailAnime(id: String) = doRequest {
        service.fetchDetailsAnime(id)
    }
}