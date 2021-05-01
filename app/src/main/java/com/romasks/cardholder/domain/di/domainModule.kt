package com.romasks.cardholder.domain.di

import com.romasks.cardholder.domain.usecase.CollectCardsUseCase
import com.romasks.cardholder.domain.usecase.SaveBarcodeUseCase
import org.koin.dsl.module

val domainModule = module {
    single { CollectCardsUseCase(get()) }
    single { SaveBarcodeUseCase(get()) }
}