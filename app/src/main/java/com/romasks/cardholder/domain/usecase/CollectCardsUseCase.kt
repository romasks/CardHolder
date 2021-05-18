package com.romasks.cardholder.domain.usecase

import com.romasks.cardholder.data.repository.CardsRepository
import com.romasks.cardholder.domain.entity.Card
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollectCardsUseCase(private val repository: CardsRepository) {

    /*fun getAllCards(): LiveData<List<Card>> = liveData {
        val cardsLiveData = cardsRepository.getAllCards()
        emitSource(cardsLiveData.map { Card(it.id, it.name, it.imageUrl, it.scheme, it.bitmap) })
    }*/

    fun getAllCards() = repository.getAllCards().map {
        Card(it.id, it.name, it.imageUrl, it.scheme, it.bitmap)
    }

    fun loadTestData() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.loadInitialCardsList()
        }
    }
}