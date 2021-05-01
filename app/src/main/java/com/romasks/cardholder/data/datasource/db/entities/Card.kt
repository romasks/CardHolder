package com.romasks.cardholder.data.datasource.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.romasks.cardholder.core.BarcodeFormat

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String,
    val scheme: BarcodeFormat
)