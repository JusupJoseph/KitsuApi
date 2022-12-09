package com.example.kitsu.ui.fragments

import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(private val repository: MangaRepository) :
    BaseViewModel() {
    fun fetchManga(limit: Int, offset: Int) = repository.fetchManga(limit, offset)
}