package com.romasks.cardholder.data.di

import com.romasks.cardholder.data.repository.CardsRepository
import org.koin.dsl.module

val repoModule = module {
    single { CardsRepository() }
}