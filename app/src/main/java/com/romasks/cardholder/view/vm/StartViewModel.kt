package com.romasks.cardholder.view.vm

import androidx.lifecycle.ViewModel
import com.romasks.cardholder.domain.binder.ILoadTestDataUseCase

class StartViewModel(
  private val useCase: ILoadTestDataUseCase
) : ViewModel() {

  fun loadTestData() {
    useCase.loadTestData()
  }
}