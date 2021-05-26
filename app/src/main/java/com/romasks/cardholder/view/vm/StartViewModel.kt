package com.romasks.cardholder.view.vm

import androidx.lifecycle.ViewModel
import com.romasks.cardholder.domain.usecase.LoadTestDataUseCase

class StartViewModel(
  private val useCase: LoadTestDataUseCase
) : ViewModel() {

  fun loadTestData() {
    useCase.loadTestData()
  }
}