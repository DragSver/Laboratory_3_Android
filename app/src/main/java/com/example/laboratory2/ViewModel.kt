package com.example.laboratory2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.laboratory2.dagger.DaggerAppComponent
import com.example.laboratory2.dagger.usecase.UseCase
import retrofit2.Response
import javax.inject.Inject


class ViewModel : ViewModel() {

    lateinit var response: Response<List<CardInfo>>
    var cardData: MutableLiveData<List<Card>>? = null

    @Inject lateinit var useCase: UseCase

    suspend fun getData(): List<Card>? {
        if (cardData == null) {
            DaggerAppComponent.builder().build().inject(this)
            cardData = MutableLiveData<List<Card>>()
            loadData()
        }
        return cardData!!.value
    }

    private suspend fun loadData() {
        response = useCase.getCardsInfo()
        val cardsInfo = response.body()!!
        cardData!!.value = cardsInfo.map { cardInfo -> Card.CardFactory.create(cardInfo) }
    }
}