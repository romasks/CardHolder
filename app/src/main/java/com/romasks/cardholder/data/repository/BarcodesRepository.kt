package com.romasks.cardholder.data.repository

import com.romasks.cardholder.data.datasource.db.dao.BarcodesDao
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import kotlinx.coroutines.runBlocking

class BarcodesRepository(private val dao: BarcodesDao) {

    fun insert(barcode: Barcode) = runBlocking { dao.insert(barcode) }
}