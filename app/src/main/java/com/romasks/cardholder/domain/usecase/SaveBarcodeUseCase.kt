package com.romasks.cardholder.domain.usecase

import com.romasks.cardholder.data.datasource.db.entities.Barcode
import com.romasks.cardholder.data.repository.BarcodesRepository

class SaveBarcodeUseCase(private val barcodesRepository: BarcodesRepository) {

    fun saveNewBarcode(cardId: Int, barcode: String) {
        barcodesRepository.insert(
            Barcode(1, cardId, barcode)
        )
    }
}