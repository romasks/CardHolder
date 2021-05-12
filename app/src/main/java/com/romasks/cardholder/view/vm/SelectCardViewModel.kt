package com.romasks.cardholder.view.vm

import androidx.lifecycle.*
import com.romasks.cardholder.domain.entity.Card
import com.romasks.cardholder.domain.usecase.CollectCardsUseCase
import kotlinx.coroutines.launch

class SelectCardViewModel(
    private val collectCardsUseCase: CollectCardsUseCase
) : ViewModel() {

    val cards = MutableLiveData<List<Card>>()
    val isNoCards = MutableLiveData(true)

    val selectedCard = MutableLiveData<Card>()

    init {
        viewModelScope.launch {
            cards.value = collectCardsUseCase.getAllCards()
            isNoCards.value = cards.value?.isEmpty() ?: true
        }
    }

    fun selectCard(card: Card) {
        selectedCard.value = card
    }
}