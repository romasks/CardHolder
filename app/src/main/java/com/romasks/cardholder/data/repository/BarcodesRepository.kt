package com.romasks.cardholder.data.repository

import androidx.annotation.WorkerThread
import com.romasks.cardholder.data.datasource.db.dao.BarcodesDao
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BarcodesRepository(private val dao: BarcodesDao) {

  //    val barcodes = liveData { emitSource(dao.getAll()) }
  val allBarcodes: Flow<List<Barcode>> = dao.getAllBarcodes()

  @WorkerThread
  suspend fun getSavedCards() = withContext(Dispatchers.IO) {
    dao.getBarcodesList()
  }

  @WorkerThread
  suspend fun insert(barcode: Barcode) = withContext(Dispatchers.IO) {
    dao.insert(barcode)
  }
}