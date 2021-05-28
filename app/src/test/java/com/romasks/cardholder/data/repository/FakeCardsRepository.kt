package com.romasks.cardholder.data.repository

import com.romasks.cardholder.core.BarcodeScheme
import com.romasks.cardholder.data.binder.ICardsRepository
import com.romasks.cardholder.data.datasource.db.entities.Card
import kotlinx.coroutines.flow.Flow

class FakeCardsRepository : ICardsRepository {

  private val cards = mutableListOf<Card>()

  init {
    cards.addAll(
      listOf(
        Card(
          id = 1,
          name = "Belorusneft",
          imageUrl = "https://dl.dropboxusercontent.com/s/px6jewcwo7aonzv/belorusneft.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        ),
        Card(
          id = 2,
          name = "Gazpromneft",
          imageUrl = "https://dl.dropboxusercontent.com/s/b4rn7c4v4vcy48m/gazpromneft.jpg?dl=0",
          scheme = BarcodeScheme.CODE_128
        ),
        Card(
          id = 3,
          name = "Mile",
          imageUrl = "https://dl.dropboxusercontent.com/s/apx6mokbw3kfdd8/mile.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        ),
        Card(
          id = 4,
          name = "Oma",
          imageUrl = "https://dl.dropboxusercontent.com/s/up42yzul4uwbzrn/oma.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        )
      )
    )
  }

  override fun getCardsAsFlow(): Flow<List<Card>> {
    TODO("Not yet implemented")
  }

  override fun getCards(): List<Card> = cards

  override fun insertCards(cards: List<Card>) {
    TODO("Not yet implemented")
  }

  override fun updateCards(cards: List<Card>) {
    TODO("Not yet implemented")
  }

  override fun clearCards(): Int {
    TODO("Not yet implemented")
  }
}