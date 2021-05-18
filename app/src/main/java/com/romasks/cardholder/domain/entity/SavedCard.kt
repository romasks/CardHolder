package com.romasks.cardholder.domain.entity

import android.graphics.Bitmap

data class SavedCard(
    val code: String,
    val cardName: String,
    val cardBitmap: Bitmap?
)
