package com.romasks.cardholder.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.romasks.cardholder.R
import com.romasks.cardholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        setUpBottomNav()
    }

    private fun setUpBottomNav() {
        val host: NavHostFragment =
            supportFragmentManager.findFragmentByTag("fragment_nav_host") as NavHostFragment
        val navController = host.navController

        val bottomNavBarConfig = AppBarConfiguration(
            setOf(
                R.id.nav_cards,
                R.id.nav_add_card,
                R.id.nav_settings
            )
        )
        setupActionBarWithNavController(navController, bottomNavBarConfig)
        binding.bottomNavMenu.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}