package com.romasks.cardholder.domain.usecase

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.romasks.cardholder.core.BarcodeScheme
import com.romasks.cardholder.data.repository.ICardsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoadTestDataUseCase(
  private val context: Context,
  private val repository: ICardsRepository
) {

  fun loadTestData() {
    CoroutineScope(Dispatchers.IO).launch {
      loadInitialCardsList()
    }
  }

  private fun loadInitialCardsList() {
    repository.clearCards()
    repository.insertCards(
      listOf(
        com.romasks.cardholder.data.datasource.db.entities.Card(
          name = "Belorusneft",
          imageUrl = "https://dl.dropboxusercontent.com/s/px6jewcwo7aonzv/belorusneft.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        ),
        com.romasks.cardholder.data.datasource.db.entities.Card(
          name = "Gazpromneft",
          imageUrl = "https://dl.dropboxusercontent.com/s/b4rn7c4v4vcy48m/gazpromneft.jpg?dl=0",
          scheme = BarcodeScheme.CODE_128
        ),
        com.romasks.cardholder.data.datasource.db.entities.Card(
          name = "Mile",
          imageUrl = "https://dl.dropboxusercontent.com/s/apx6mokbw3kfdd8/mile.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        ),
        com.romasks.cardholder.data.datasource.db.entities.Card(
          name = "Oma",
          imageUrl = "https://dl.dropboxusercontent.com/s/up42yzul4uwbzrn/oma.jpg?dl=0",
          scheme = BarcodeScheme.EAN_13
        )
      )
    )
    repository.updateCards(repository.getCards().map { it.bitmap = loadImage(it.imageUrl); it })
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