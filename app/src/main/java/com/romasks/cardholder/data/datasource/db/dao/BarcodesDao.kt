package com.romasks.cardholder.data.datasource.db.dao

import androidx.room.*
import com.romasks.cardholder.data.datasource.db.entities.Barcode

@Dao
interface BarcodesDao {

    @Query("SELECT * FROM barcode")
    suspend fun getAll(): List<Barcode>

    @Query("SELECT * FROM barcode WHERE id == :id")
    suspend fun getById(id: Int): Barcode

    @Query("SELECT * FROM barcode WHERE barcode LIKE :code")
    suspend fun getByCode(code: String): List<Barcode>

    @Insert
    suspend fun insert(barcode: Barcode): Long

    @Update
    suspend fun update(barcode: Barcode): Int

    @Delete
    suspend fun delete(barcode: Barcode): Int

    @Query("DELETE FROM barcode")
    suspend fun clearAll(): Int
}