package com.romasks.cardholder.data.repository

import com.romasks.cardholder.data.datasource.db.dao.BarcodesDao
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import kotlinx.coroutines.runBlocking

class BarcodesRepository(private val dao: BarcodesDao) {

    //    val barcodes = liveData { emitSource(dao.getAll()) }
    val barcodes = dao.getAll()

    fun getSavedCards() = runBlocking { dao.getBarcodesList() }

    fun insert(barcode: Barcode) = runBlocking { dao.insert(barcode) }
}