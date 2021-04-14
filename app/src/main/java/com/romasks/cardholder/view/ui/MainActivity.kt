package com.romasks.cardholder.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.romasks.cardholder.R
import com.romasks.cardholder.view.vm.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}