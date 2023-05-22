package com.example.laboratory2.api

import com.example.laboratory2.CardInfo
import dagger.Module
import dagger.Provides
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiService {
    @GET("new_text.json")
    suspend fun getCardsInfo(): Response<List<CardInfo>>
}
