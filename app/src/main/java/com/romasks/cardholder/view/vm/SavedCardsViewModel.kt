package com.romasks.cardholder.view.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.romasks.cardholder.domain.entity.SavedCard
import com.romasks.cardholder.domain.usecase.CollectSavedCardsUseCase

class SavedCardsViewModel(
    useCase: CollectSavedCardsUseCase
) : ViewModel() {

    private val _selectedCard = MutableLiveData<SavedCard?>()

    val cards = useCase.getSavedCards()

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