package com.romasks.cardholder.data.datasource.db.dao

import androidx.room.*
import com.romasks.cardholder.data.datasource.db.entities.Card

@Dao
interface CardsDao {

    @Query("SELECT * FROM card")
    suspend fun getAll(): List<Card>

    @Query("SELECT * FROM card WHERE id == :id")
    suspend fun getById(id: Int): Card

    @Query("SELECT * FROM card WHERE name LIKE :cardName")
    suspend fun getByName(cardName: String): List<Card>

    @Insert
    suspend fun insert(card: Card): Long

    @Update
    suspend fun update(card: Card): Int

    @Delete
    suspend fun delete(card: Card): Int

    @Query("DELETE FROM card")
    suspend fun clearAll(): Int
}