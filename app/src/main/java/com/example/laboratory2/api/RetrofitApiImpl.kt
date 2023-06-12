package com.example.laboratory2.api

import com.example.laboratory2.dagger.NetworkModule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

class RetrofitApiImpl @Inject constructor () : RetrofitApi {
    val API_URL = "https://develtop.ru/study/"

    override fun provideApiService(): ApiService = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create()
}