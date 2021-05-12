package com.romasks.cardholder.domain.entity

import android.graphics.Bitmap
import android.os.Parcelable
import com.romasks.cardholder.core.BarcodeScheme
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val scheme: BarcodeScheme,
    val bitmap: Bitmap?
) : Parcelable
