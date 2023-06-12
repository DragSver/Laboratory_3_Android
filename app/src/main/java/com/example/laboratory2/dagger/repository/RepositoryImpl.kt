package com.example.laboratory2.dagger.repository

import com.example.laboratory2.CardInfo
import com.example.laboratory2.api.ApiService
import com.example.laboratory2.api.RetrofitApi
import retrofit2.Response
import javax.inject.Inject

//class RepositoryImpl @Inject constructor (var apiService: ApiService) : Repository {
//
//    override suspend fun getCardsInfo(): Response<List<CardInfo>> = apiService.getCardsInfo()
//}

class RepositoryImpl @Inject constructor (var retrofitApi: RetrofitApi) : Repository {

    override suspend fun getCardsInfo(): Response<List<CardInfo>> = retrofitApi.provideApiService().getCardsInfo()
}