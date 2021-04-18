package com.romasks.cardholder.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.romasks.cardholder.databinding.FragmentAddCardBinding

class AddCardFragment : Fragment() {

    private lateinit var binding: FragmentAddCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCardBinding.inflate(layoutInflater)
        return binding.root
    }
}