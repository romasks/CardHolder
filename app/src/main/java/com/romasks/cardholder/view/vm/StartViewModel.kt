package com.romasks.cardholder.view.vm

import androidx.lifecycle.ViewModel
import com.romasks.cardholder.domain.usecase.CollectCardsUseCase

class StartViewModel(
    private val collectCardsUseCase: CollectCardsUseCase
) : ViewModel() {

    fun loadTestData() {
        collectCardsUseCase.loadTestData()
    }
}