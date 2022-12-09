package com.example.kitsu.data.remote

import com.example.kitsu.data.remote.apiservices.MangaApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .client(provideOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .callTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideMangaApiService() = retrofit.create(MangaApiService::class.java)
}