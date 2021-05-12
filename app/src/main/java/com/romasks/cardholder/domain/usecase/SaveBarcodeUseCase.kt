package com.romasks.cardholder.domain.usecase

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.romasks.cardholder.core.BarcodeScheme
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import com.romasks.cardholder.data.repository.BarcodesRepository

class SaveBarcodeUseCase(private val barcodesRepository: BarcodesRepository) {

    fun saveNewBarcode(cardId: Int, barcode: String) {
        barcodesRepository.insert(
            Barcode(cardId = cardId, barcode = barcode)
        )
    }

    fun generateBarcodeBitmap(code: String, scheme: BarcodeScheme, size: Int): Bitmap =
        BarcodeEncoder().encodeBitmap(code, scheme.toBarcodeFormat(), size, size / 2)

}

private fun BarcodeScheme.toBarcodeFormat() = when (this) {
    BarcodeScheme.EAN_13 -> BarcodeFormat.EAN_13
    BarcodeScheme.CODE_128 -> BarcodeFormat.CODE_128
}
