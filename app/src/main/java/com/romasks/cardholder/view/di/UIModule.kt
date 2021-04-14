package com.romasks.cardholder.view.di

import com.romasks.cardholder.view.vm.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { MainViewModel() }
}