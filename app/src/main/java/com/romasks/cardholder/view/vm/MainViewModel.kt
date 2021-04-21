package com.romasks.cardholder.view.vm

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.romasks.cardholder.data.repository.CardsRepository
import com.romasks.cardholder.domain.entity.Barcode
import com.romasks.cardholder.domain.entity.Card

class MainViewModel(
    // TODO: change on UseCase invocation
    private val cardsRepository: CardsRepository
) : ViewModel() {

    private lateinit var barcode: Barcode

    fun getCards() = cardsRepository.loadInitialCardsList()

    fun saveBarcode(bitmap: Bitmap?, code: String) {
        barcode = Barcode(code, bitmap)
    }

    fun saveCard(card: Card) {
        cardsRepository.saveNewCard(card, barcode)
    }
}