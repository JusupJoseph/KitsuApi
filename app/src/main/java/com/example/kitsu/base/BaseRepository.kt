package com.example.kitsu.base

import androidx.lifecycle.liveData
import com.example.kitsu.common.Resource
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> Response<T>) = liveData {
        emit(Resource.Loading())

        try {
            result().body()?.let {
                emit(Resource.Success(it))
            }
        } catch (ioException: IOException) {
            emit(ioException.localizedMessage?.let { Resource.Error(it, null) })
        }
    }
}