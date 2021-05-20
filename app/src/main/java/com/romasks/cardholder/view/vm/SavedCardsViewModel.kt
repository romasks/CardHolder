package com.romasks.cardholder.view.vm

import androidx.lifecycle.*
import com.romasks.cardholder.domain.entity.SavedCard
import com.romasks.cardholder.domain.usecase.CollectSavedCardsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class SavedCardsViewModel(
  private val useCase: CollectSavedCardsUseCase
) : ViewModel() {

  private val _selectedCard = MutableLiveData<SavedCard?>()

  val cards: LiveData<List<SavedCard>>
    get() = useCase.getSavedCards().flowOn(Dispatchers.Main)
      .asLiveData(context = viewModelScope.coroutineContext)

  val isNoCards: LiveData<Boolean>
    get() = liveData { cards.value?.isEmpty() }

  val selectedCard: LiveData<SavedCard?>
    get() = _selectedCard

  fun selectCard(card: SavedCard) {
    _selectedCard.postValue(card)
  }

  fun clearSelectedCard() {
    _selectedCard.value = null
  }
}