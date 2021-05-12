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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(card: Card)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cards: List<Card>)

    @Update
    suspend fun update(card: Card)

    @Update
    suspend fun updateAll(cards: List<Card>)

    @Delete
    suspend fun delete(card: Card)

    @Query("DELETE FROM card")
    suspend fun clearAll(): Int
}