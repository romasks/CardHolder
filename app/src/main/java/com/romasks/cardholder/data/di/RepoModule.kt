package com.romasks.cardholder.data.di

import com.romasks.cardholder.data.datasource.db.AppDatabase
import com.romasks.cardholder.data.repository.BarcodesRepository
import com.romasks.cardholder.data.repository.CardsRepository
import com.romasks.cardholder.data.repository.ICardsRepository
import org.koin.dsl.module

val repoModule = module {
  single { AppDatabase.getInstance(get()) }
  single { BarcodesRepository(get<AppDatabase>().barcodesDao) }
  single { CardsRepository(get<AppDatabase>().cardsDao) as ICardsRepository }
}