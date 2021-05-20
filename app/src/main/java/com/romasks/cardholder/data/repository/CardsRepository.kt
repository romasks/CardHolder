package com.romasks.cardholder.data.repository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.romasks.cardholder.core.BarcodeScheme
import com.romasks.cardholder.data.datasource.db.dao.CardsDao
import com.romasks.cardholder.data.datasource.db.entities.Card
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CardsRepository(
  private val context: Context,
  private val dao: CardsDao
) {

  //    val cards = liveData { emitSource(dao.getAll()) }
  val allCards: Flow<List<Card>> = dao.getAllCards()

  fun getAllCards(): List<Card> = runBlocking { dao.getCardsList() }

  fun insertAll(cards: List<Card>) = runBlocking { dao.insertAll(cards) }

  fun updateAll(cards: List<Card>) = runBlocking { dao.updateAll(cards) }

  fun clearAll() = runBlocking { dao.clearAll() }

  fun loadInitialCardsList() {
    val res = context.resources
    // @formatter:off
    clearAll()
    insertAll(
      listOf(
        Card(
          name = "Belorusneft",
          imageUrl = "https://dl.dropboxusercontent.com/s/px6jewcwo7aonzv/belorusneft.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        ),
        Card(
          name = "Gazpromneft",
          imageUrl = "https://dl.dropboxusercontent.com/s/b4rn7c4v4vcy48m/gazpromneft.jpg?dl=0",
          scheme = BarcodeScheme.CODE_128
        ),
        Card(
          name = "Mile",
          imageUrl = "https://dl.dropboxusercontent.com/s/apx6mokbw3kfdd8/mile.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        ),
        Card(
          name = "Oma",
          imageUrl = "https://dl.dropboxusercontent.com/s/up42yzul4uwbzrn/oma.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        )
      )
    )
    updateAll(getAllCards().map { it.bitmap = loadImage(it.imageUrl); it })
    // @formatter:on
  }

  private fun loadImage(imageUrl: String): Bitmap? {
    var bitmap: Bitmap? = null
    CoroutineScope(Dispatchers.IO).launch {
      val loader = ImageLoader(context)
      val request = ImageRequest.Builder(context)
        .data(imageUrl)
        .allowHardware(false)
        .build()

      val result = (loader.execute(request) as SuccessResult).drawable
      bitmap = (result as BitmapDrawable).bitmap
    }
    return bitmap
  }
}