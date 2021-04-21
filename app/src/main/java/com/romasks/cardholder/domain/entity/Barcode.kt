package com.romasks.cardholder.domain.entity

import android.graphics.Bitmap

data class Barcode(
    private val code: String,
    private val bitmap: Bitmap?
)
