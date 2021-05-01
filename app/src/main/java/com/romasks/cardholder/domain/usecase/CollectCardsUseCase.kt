package com.romasks.cardholder.domain.usecase

import com.romasks.cardholder.data.datasource.db.entities.Card
import com.romasks.cardholder.data.repository.CardsRepository

class CollectCardsUseCase(private val cardsRepository: CardsRepository) {

    fun getAllCards(): List<Card> {
        val cards = cardsRepository.cards
        return if (cards.isEmpty()) {
            cardsRepository.loadInitialCardsList()
            cardsRepository.cards
        } else {
            cards
        }
    }
}