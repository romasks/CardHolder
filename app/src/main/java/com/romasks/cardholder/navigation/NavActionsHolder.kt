package com.romasks.cardholder.navigation

import com.github.terrakok.cicerone.Navigator

interface NavActionsHolder {
    fun setNavigator(navigator: Navigator)
    fun removeNavigator()
}