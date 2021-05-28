package com.romasks.cardholder.data.binder

import com.romasks.cardholder.data.datasource.db.entities.Card
import kotlinx.coroutines.flow.Flow

interface ICardsRepository {

  fun getCardsAsFlow(): Flow<List<Card>>
  fun getCards(): List<Card>
  fun insertCards(cards: List<Card>)
  fun updateCards(cards: List<Card>)
  fun clearCards(): Int
}