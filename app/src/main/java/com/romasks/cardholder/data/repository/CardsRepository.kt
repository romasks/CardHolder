package com.romasks.cardholder.data.repository

import com.romasks.cardholder.data.binder.ICardsRepository
import com.romasks.cardholder.data.datasource.db.dao.CardsDao
import com.romasks.cardholder.data.datasource.db.entities.Card
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking

class CardsRepository(private val dao: CardsDao): ICardsRepository {

  //    val cards = liveData { emitSource(dao.getAll()) }
  override fun getCardsAsFlow(): Flow<List<Card>> = dao.getAllCards()

  override fun getCards(): List<Card> = runBlocking { dao.getCardsList() }

  override fun insertCards(cards: List<Card>) = runBlocking { dao.insertAll(cards) }

  override fun updateCards(cards: List<Card>) = runBlocking { dao.updateAll(cards) }

  override fun clearCards() = runBlocking { dao.clearAll() }
}