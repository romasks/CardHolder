package com.romasks.cardholder.data.binder

import com.romasks.cardholder.data.datasource.db.entities.Barcode
import kotlinx.coroutines.flow.Flow

interface IBarcodesRepository {
  val allBarcodes: Flow<List<Barcode>>
  suspend fun getSavedCards(): List<Barcode>
  suspend fun insert(barcode: Barcode): Long
}