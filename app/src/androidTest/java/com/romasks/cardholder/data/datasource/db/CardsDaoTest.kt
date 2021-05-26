package com.romasks.cardholder.data.datasource.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.romasks.cardholder.data.cardsList
import com.romasks.cardholder.data.datasource.db.dao.CardsDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardsDaoTest {

  @get:Rule
  var instantTaskExecutorRule = InstantTaskExecutorRule()

  private lateinit var dao: CardsDao
  private lateinit var database: AppDatabase

  @Before
  fun setUp() {
    database = Room.inMemoryDatabaseBuilder(
      ApplicationProvider.getApplicationContext(),
      AppDatabase::class.java
    ).build()
    dao = database.cardsDao
  }

  @After
  fun tearDown() {
    database.close()
  }

  @Test
  fun insertCardsTest() = runBlocking {
    val cards = cardsList
    dao.insertAll(cards)

    val result = dao.getCardsList()
    Truth.assertThat(result).isEqualTo(cards)
  }
}