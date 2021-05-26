package com.romasks.cardholder.domain.di

import com.romasks.cardholder.domain.usecase.CollectCardsUseCase
import com.romasks.cardholder.domain.usecase.CollectSavedCardsUseCase
import com.romasks.cardholder.domain.usecase.LoadTestDataUseCase
import com.romasks.cardholder.domain.usecase.SaveBarcodeUseCase
import org.koin.dsl.module

val domainModule = module {
  single { CollectCardsUseCase(get()) }
  single { CollectSavedCardsUseCase(get(), get()) }
  single { LoadTestDataUseCase(get(), get()) }
  single { SaveBarcodeUseCase(get()) }
}