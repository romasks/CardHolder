package com.romasks.cardholder.data.repository

import androidx.annotation.WorkerThread
import com.romasks.cardholder.data.binder.IBarcodesRepository
import com.romasks.cardholder.data.datasource.db.dao.BarcodesDao
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BarcodesRepository(private val dao: BarcodesDao) : IBarcodesRepository {

  //    val barcodes = liveData { emitSource(dao.getAll()) }
  override val allBarcodes: Flow<List<Barcode>> = dao.getAllBarcodes()

  @WorkerThread
  override suspend fun getSavedCards() = withContext(Dispatchers.IO) {
    dao.getBarcodesList()
  }

  @WorkerThread
  override suspend fun insert(barcode: Barcode) = withContext(Dispatchers.IO) {
    dao.insert(barcode)
  }
}