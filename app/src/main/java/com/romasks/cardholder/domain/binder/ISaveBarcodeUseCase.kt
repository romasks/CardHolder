package com.romasks.cardholder.domain.binder

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import com.romasks.cardholder.core.BarcodeScheme
import kotlinx.coroutines.Job

interface ISaveBarcodeUseCase {
  val barcode: LiveData<String>
  val barcodeBitmap: LiveData<Bitmap>
  suspend fun saveNewBarcode(cardId: Int, barcode: String)
  fun generateBarcodeBitmap(code: String, scheme: BarcodeScheme, size: Int): Job
}