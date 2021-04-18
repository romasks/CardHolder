package com.romasks.cardholder.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.romasks.cardholder.databinding.FragmentCardsBinding

class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(layoutInflater)
        return binding.root
    }
}