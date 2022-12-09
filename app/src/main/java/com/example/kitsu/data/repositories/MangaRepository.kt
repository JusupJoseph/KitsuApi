package com.example.kitsu.data.repositories

import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun fetchManga(limit: Int, offset: Int) = doRequest {
        service.fetchManga(limit, offset)
    }
}