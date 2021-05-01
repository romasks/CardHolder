package com.romasks.cardholder.view.vm

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import com.romasks.cardholder.data.datasource.db.entities.Card
import com.romasks.cardholder.domain.usecase.CollectCardsUseCase
import com.romasks.cardholder.domain.usecase.SaveBarcodeUseCase

class MainViewModel(
    private val collectCardsUseCase: CollectCardsUseCase,
    private val saveBarcodeUseCase: SaveBarcodeUseCase
) : ViewModel() {

    private lateinit var barcode: String
    private var barcodeBitmap: Bitmap? = null

    fun getCards() = collectCardsUseCase.getAllCards()

    fun saveBarcode(bitmap: Bitmap?, code: String) {
        barcode = code
        barcodeBitmap = bitmap
    }

    fun saveCard(card: Card) {
        saveBarcodeUseCase.saveNewBarcode(card.id, barcode)
    }
}