package com.romasks.cardholder.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.romasks.cardholder.databinding.FragmentCardsBinding
import com.romasks.cardholder.view.adapter.SavedCardsAdapter
import com.romasks.cardholder.view.vm.SavedCardsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SavedCardsFragment : Fragment() {

    private val viewModel by viewModel<SavedCardsViewModel>()

    private lateinit var binding: FragmentCardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        viewModel.selectedCard.observe(viewLifecycleOwner) { card ->
            card?.let {
                val bundle = bundleOf("selectedCard" to it)
                // TODO: navigate to screen with barcode
                viewModel.clearSelectedCard()
            }
        }
    }

    private fun setAdapter() {
        val cardsAdapter = SavedCardsAdapter { card -> viewModel.selectCard(card) }
        binding.savedCardsList.run {
            adapter = cardsAdapter
        }
        viewModel.cards.observe(viewLifecycleOwner) {
            cardsAdapter.setItems(it)
        }
    }
}