package com.romasks.cardholder.view.vm

import androidx.lifecycle.*
import com.romasks.cardholder.domain.entity.Card
import com.romasks.cardholder.domain.usecase.CollectCardsUseCase
import kotlinx.coroutines.launch

class SelectCardViewModel(
    private val collectCardsUseCase: CollectCardsUseCase
) : ViewModel() {

    private val _cards = MutableLiveData<List<Card>>()
    private val _selectedCard = MutableLiveData<Card?>()

    val cards: LiveData<List<Card>>
        get() = _cards

    val isNoCards: LiveData<Boolean>
        get() = liveData {
            _cards.value?.isEmpty()
        }

    val selectedCard: LiveData<Card?>
        get() = _selectedCard

    init {
        viewModelScope.launch {
            _cards.postValue(collectCardsUseCase.getAllCards())
        }
    }

    fun selectCard(card: Card) {
        _selectedCard.postValue(card)
    }

    fun clearSelectedCard() {
        _selectedCard.value = null
    }
}