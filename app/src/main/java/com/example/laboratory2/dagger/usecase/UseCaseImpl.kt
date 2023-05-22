package com.example.laboratory2.dagger.usecase

import com.example.laboratory2.dagger.repository.Repository
import javax.inject.Inject

class UseCaseImpl @Inject constructor(private val repository: Repository) : UseCase {



     override suspend fun getCardsInfo() = repository.getCardsInfo()
}