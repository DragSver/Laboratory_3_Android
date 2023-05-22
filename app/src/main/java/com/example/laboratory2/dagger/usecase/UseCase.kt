package com.example.laboratory2.dagger.usecase

import com.example.laboratory2.CardInfo
import retrofit2.Response

interface UseCase {
    suspend fun getCardsInfo(): Response<List<CardInfo>>
}