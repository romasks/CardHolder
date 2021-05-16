package com.romasks.cardholder.domain.usecase

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.romasks.cardholder.core.BarcodeScheme
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import com.romasks.cardholder.data.repository.BarcodesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SaveBarcodeUseCase(private val barcodesRepository: BarcodesRepository) {

    private val _barcode = MutableLiveData<String>()
    private val _barcodeBitmap = MutableLiveData<Bitmap>()

    val barcode: LiveData<String>
        get() = _barcode

    val barcodeBitmap: LiveData<Bitmap>
        get() = _barcodeBitmap

    fun saveNewBarcode(cardId: Int, barcode: String) {
        barcodesRepository.insert(
            Barcode(cardId = cardId, barcode = barcode)
        )
    }

    fun generateBarcodeBitmap(code: String, scheme: BarcodeScheme, size: Int) =
        CoroutineScope(Dispatchers.Default).launch {
            _barcode.postValue(code)

            val bitmap =
                BarcodeEncoder().encodeBitmap(code, scheme.toBarcodeFormat(), size, size / 2)
            _barcodeBitmap.postValue(bitmap)
        }

}

private fun BarcodeScheme.toBarcodeFormat() = when (this) {
    BarcodeScheme.EAN_13 -> BarcodeFormat.EAN_13
    BarcodeScheme.CODE_128 -> BarcodeFormat.CODE_128
}
