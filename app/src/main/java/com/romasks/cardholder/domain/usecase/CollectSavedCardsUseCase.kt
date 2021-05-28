package com.romasks.cardholder.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.romasks.cardholder.data.binder.ICardsRepository
import com.romasks.cardholder.data.datasource.db.entities.Barcode
import com.romasks.cardholder.data.datasource.db.entities.Card
import com.romasks.cardholder.data.repository.BarcodesRepository
import com.romasks.cardholder.domain.binder.ICollectSavedCardsUseCase
import com.romasks.cardholder.domain.entity.SavedCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

class CollectSavedCardsUseCase(
  private val cardsRepository: ICardsRepository,
  private val repository: BarcodesRepository
) : ICollectSavedCardsUseCase {

  private val cards: LiveData<List<Card>> = cardsRepository.getCardsAsFlow()
    .asLiveData(context = CoroutineScope(Dispatchers.IO).coroutineContext)

  // TODO: doesn't load changes from DB after save new Barcode. Some problem with coroutines + liveData
  /*private val barcodes = liveData<List<Barcode>> {
      repository.getSavedCards()
  }*/
  private val barcodes: Flow<List<Barcode>> = repository.allBarcodes

  override fun getSavedCards(): Flow<List<SavedCard>> = barcodes.transform { barcodesList ->
    barcodesList.map { barcode ->
      val card = cards.value?.first { card -> card.id == barcode.cardId }
      card?.let { SavedCard(barcode.barcode, it.name, it.bitmap) }
    }
  }

}