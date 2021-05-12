package com.romasks.cardholder.view.di

import com.romasks.cardholder.view.vm.NewCardResultViewModel
import com.romasks.cardholder.view.vm.SelectCardViewModel
import com.romasks.cardholder.view.vm.StartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { NewCardResultViewModel(get()) }
    viewModel { SelectCardViewModel(get()) }
    viewModel { StartViewModel(get()) }
}