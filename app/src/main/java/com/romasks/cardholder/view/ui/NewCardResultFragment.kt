package com.romasks.cardholder.view.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.zxing.integration.android.IntentIntegrator
import com.romasks.cardholder.R
import com.romasks.cardholder.databinding.FragmentNewCardResultBinding
import com.romasks.cardholder.domain.entity.Card
import com.romasks.cardholder.view.vm.NewCardResultViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class NewCardResultFragment : Fragment() {

    private val viewModel by viewModel<NewCardResultViewModel>()

    private lateinit var binding: FragmentNewCardResultBinding

    init {
        lifecycleScope.launchWhenStarted {
            binding.btnCancel.setBackgroundColor(Color.WHITE)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IntentIntegrator.forSupportFragment(this).initiateScan()

        viewModel.setSelectedCard(arguments?.get("selectedCard") as Card)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewCardResultBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedCard.observe(viewLifecycleOwner) { card ->
            card.bitmap
                ?.let { binding.selectedCardImage.load(card.bitmap) }
                ?: binding.selectedCardImage.load(card.imageUrl)
        }
        viewModel.barcodeBitmap.observe(viewLifecycleOwner) { bitmap ->
            binding.barcodeImage.load(bitmap)
        }
        viewModel.barcode.observe(viewLifecycleOwner) { code ->
            binding.code.text = code
        }
        viewModel.navigateBack.observe(viewLifecycleOwner) { back ->
            if (back) {
                findNavController().popBackStack()
                viewModel.navigateBack.value = false
            }
        }
        viewModel.cardSaved.observe(viewLifecycleOwner) { saved ->
            if (saved) {
                findNavController().navigate(R.id.action_newCardResultFragment_to_cards)
                viewModel.cardSaved.value = false
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            ?.let { viewModel.generateBarcodeBitmap(it.contents, binding.barcodeImage.width) }
            ?: super.onActivityResult(requestCode, resultCode, data)
    }
}