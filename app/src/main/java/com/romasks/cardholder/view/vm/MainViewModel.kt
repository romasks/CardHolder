package com.romasks.cardholder.view.vm

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Navigator
import com.romasks.cardholder.navigation.NavHelper

class MainViewModel(
    private val navHelper: NavHelper
) : ViewModel() {

    fun setNavigator(navigator: Navigator) {
        navHelper.setNavigator(navigator)
    }

    fun removeNavigator() {
        navHelper.removeNavigator()
    }
}