package com.romasks.cardholder.navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator

object NavHelper : NavActionsHolder {

    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun setNavigator(navigator: Navigator) {
        navigatorHolder.setNavigator(navigator)
    }

    override fun removeNavigator() {
        navigatorHolder.removeNavigator()
    }

}