package com.romasks.cardholder.data.repository

import android.content.Context
import com.romasks.cardholder.R
import com.romasks.cardholder.core.BarcodeFormat
import com.romasks.cardholder.data.datasource.db.dao.CardsDao
import com.romasks.cardholder.data.datasource.db.entities.Card
import kotlinx.coroutines.runBlocking

class CardsRepository(
    private val context: Context,
    private val dao: CardsDao
) {

    val cards = runBlocking { dao.getAll() }

    fun insert(card: Card) = runBlocking { dao.insert(card) }

    fun loadInitialCardsList() {
        val res = context.resources
        // @formatter:off
        insert(Card(1,"Belorusneft", res.getString(R.drawable.belorusneft), BarcodeFormat.EAN_13))
        insert(Card(2, "Gazpromneft", res.getString(R.drawable.gazpromneft), BarcodeFormat.CODE_128))
        insert(Card(3, "Mile", res.getString(R.drawable.mile), BarcodeFormat.EAN_13))
        insert(Card(4, "Oma", res.getString(R.drawable.oma), BarcodeFormat.EAN_13))
        // @formatter:on
    }
}