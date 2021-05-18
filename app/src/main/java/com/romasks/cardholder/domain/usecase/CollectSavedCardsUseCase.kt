package com.romasks.cardholder.domain.usecase

import androidx.lifecycle.liveData
import com.romasks.cardholder.data.repository.BarcodesRepository
import com.romasks.cardholder.data.repository.CardsRepository
import com.romasks.cardholder.domain.entity.SavedCard

class CollectSavedCardsUseCase(
    private val cardsRepository: CardsRepository,
    private val repository: BarcodesRepository
) {

    private val cards = cardsRepository.getAllCards()

    // TODO: doesn't load changes from DB after save new Barcode. Some problem with coroutines + liveData
    private val barcodes = repository.getSavedCards()

    fun getSavedCards() = liveData<List<SavedCard>> {
        barcodes.map { barcode ->
            val card = cards.first { card -> card.id == barcode.cardId }
            card.let { SavedCard(barcode.barcode, it.name, it.bitmap) }
        }
    }
}