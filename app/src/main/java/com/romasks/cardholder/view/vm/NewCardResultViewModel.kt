package com.romasks.cardholder.view.vm

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.romasks.cardholder.domain.entity.Card
import com.romasks.cardholder.domain.usecase.SaveBarcodeUseCase

class NewCardResultViewModel(
    private val saveBarcodeUseCase: SaveBarcodeUseCase
) : ViewModel() {

    val selectedCard = MutableLiveData<Card>()

    val barcode = MutableLiveData<String>()
    val barcodeBitmap = MutableLiveData<Bitmap>()

    val navigateBack = MutableLiveData(false)
    val cardSaved = MutableLiveData(false)

    fun setSelectedCard(card: Card) {
        selectedCard.value = card
    }

    fun generateBarcodeBitmap(code: String, imageWidth: Int) {
        barcode.value = code
        barcodeBitmap.value =
            saveBarcodeUseCase.generateBarcodeBitmap(code, selectedCard.value!!.scheme, imageWidth)
    }

    fun cancel() {
        navigateBack.value = true
    }

    fun saveCard() {
        saveBarcodeUseCase.saveNewBarcode(selectedCard.value!!.id, barcode.value!!)
        cardSaved.value = true
    }
}