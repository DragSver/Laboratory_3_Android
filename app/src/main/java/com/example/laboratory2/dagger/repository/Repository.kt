package com.example.laboratory2.dagger.repository

import com.example.laboratory2.CardInfo
import retrofit2.Response

interface Repository {
    suspend fun getCardsInfo(): Response<List<CardInfo>>
}