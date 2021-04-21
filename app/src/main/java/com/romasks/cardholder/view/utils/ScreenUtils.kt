package com.romasks.cardholder.view.utils

import android.app.Activity
import android.graphics.Point
import android.view.Display

object ScreenUtils {

    var screenWidth: Int = 0

    fun calculateScreenWidth(activity: Activity?) {
        val display: Display? = activity?.windowManager?.defaultDisplay
        val size = Point()
        display?.getSize(size)
        screenWidth = size.x
    }
}