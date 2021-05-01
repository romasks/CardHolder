package com.romasks.cardholder.data.datasource.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Card::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("card_id"),
        onDelete = CASCADE
    )]
)
data class Barcode(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "card_id", index = true)
    val cardId: Int,
    val barcode: String
)