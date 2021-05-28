package com.romasks.cardholder.domain.usecase

import com.romasks.cardholder.data.binder.ICardsRepository
import com.romasks.cardholder.domain.binder.ICollectCardsUseCase
import com.romasks.cardholder.domain.entity.Card

class CollectCardsUseCase(private val repository: ICardsRepository) : ICollectCardsUseCase {

  /*fun getAllCards(): LiveData<List<Card>> = liveData {
      val cardsLiveData = cardsRepository.getAllCards()
      emitSource(cardsLiveData.map { Card(it.id, it.name, it.imageUrl, it.scheme, it.bitmap) })
  }*/

  override fun getAllCards() = repository.getCards().map {
    Card(it.id, it.name, it.imageUrl, it.scheme, it.bitmap)
  }
}