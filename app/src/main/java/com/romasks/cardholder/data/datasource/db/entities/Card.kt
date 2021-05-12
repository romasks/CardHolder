package com.romasks.cardholder.data.datasource.db.entities

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.romasks.cardholder.core.BarcodeScheme

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "scheme") val scheme: BarcodeScheme
) {
    @ColumnInfo(name = "image_bitmap")
    var bitmap: Bitmap? = null
}