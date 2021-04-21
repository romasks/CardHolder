package com.romasks.cardholder.data.repository

import com.romasks.cardholder.R
import com.romasks.cardholder.domain.entity.Barcode
import com.romasks.cardholder.domain.entity.Card

class CardsRepository {

    fun loadInitialCardsList() = listOf<Card>(
        Card("Belorusneft", R.drawable.belorusneft),
        Card("Gazpromneft", R.drawable.gazpromneft),
        Card("Mile", R.drawable.mile),
        Card("Oma", R.drawable.oma)
    )

    fun saveNewCard(card: Card, barcode: Barcode) {
        // TODO: save new card to DB
        // val user = currentUser
        // saveNewCard(user, card, barcode)
    }
}