package com.romasks.cardholder.view.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.romasks.cardholder.domain.entity.Card
import com.romasks.cardholder.domain.usecase.SaveBarcodeUseCase
import kotlinx.coroutines.launch

class NewCardResultViewModel(
    private val useCase: SaveBarcodeUseCase
) : ViewModel() {

    private val _selectedCard = MutableLiveData<Card>()
    private val _navigateBack = MutableLiveData(false)
    private val _cardSaved = MutableLiveData(false)

    val selectedCard: LiveData<Card>
        get() = _selectedCard

    val barcode = useCase.barcode
    val barcodeBitmap = useCase.barcodeBitmap

    val navigateBack: LiveData<Boolean>
        get() = _navigateBack

    val cardSaved: LiveData<Boolean>
        get() = _cardSaved

    fun setSelectedCard(card: Card) {
        _selectedCard.postValue(card)
    }

    fun generateBarcodeBitmap(code: String, imageWidth: Int) {
        viewModelScope.launch {
            useCase.generateBarcodeBitmap(code, selectedCard.value!!.scheme, imageWidth)
        }
    }

    fun cancel() {
        _navigateBack.postValue(true)
    }

    fun saveCard() {
        viewModelScope.launch {
            useCase.saveNewBarcode(selectedCard.value!!.id, barcode.value!!)
            _cardSaved.postValue(true)
        }
    }

    fun onNavigateBack() {
        _navigateBack.postValue(false)
    }

    fun onNavigateNext() {
        _cardSaved.postValue(false)
    }
}