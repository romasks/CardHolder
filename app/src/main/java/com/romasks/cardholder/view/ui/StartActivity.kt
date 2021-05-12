package com.romasks.cardholder.view.ui

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.romasks.cardholder.databinding.ActivityStartBinding
import com.romasks.cardholder.view.vm.StartViewModel
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class StartActivity : AppCompatActivity() {

    private val viewModel by viewModel<StartViewModel>()

    private lateinit var binding: ActivityStartBinding

    init {
        lifecycleScope.launchWhenStarted {
            viewModel.loadTestData()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashAnim.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                Intent(this@StartActivity, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(this)
                }
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationRepeat(animation: Animator?) {
            }
        })
    }

    override fun onStart() {
        super.onStart()
        binding.splashAnim.playAnimation()
    }
}