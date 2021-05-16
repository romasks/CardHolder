package com.romasks.cardholder.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.romasks.cardholder.R
import com.romasks.cardholder.databinding.FragmentSelectCardBinding
import com.romasks.cardholder.view.adapter.CardsAdapter
import com.romasks.cardholder.view.vm.SelectCardViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SelectCardFragment : Fragment() {

    private val viewModel by viewModel<SelectCardViewModel>()

    private lateinit var binding: FragmentSelectCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectCardBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()

        viewModel.selectedCard.observe(viewLifecycleOwner) { card ->
            card?.let {
                val bundle = bundleOf("selectedCard" to it)
                findNavController().navigate(R.id.action_open_newCardResultFragment, bundle)
                viewModel.clearSelectedCard()
            }
        }
    }

    private fun setAdapter() {
        val cardsAdapter = CardsAdapter { card -> viewModel.selectCard(card) }
        binding.cardsList.run {
            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            adapter = cardsAdapter
        }
        viewModel.cards.observe(viewLifecycleOwner) {
            cardsAdapter.setItems(it)
        }
    }
}