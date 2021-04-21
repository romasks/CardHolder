package com.romasks.cardholder.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.romasks.cardholder.databinding.FragmentAddCardBinding
import com.romasks.cardholder.domain.entity.Card
import com.romasks.cardholder.view.adapter.CardsAdapter
import com.romasks.cardholder.view.utils.ScreenUtils
import com.romasks.cardholder.view.vm.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class AddCardFragment : Fragment(), CardsAdapter.ItemClickListener {

    private val viewModel by viewModel<MainViewModel>()

    private lateinit var binding: FragmentAddCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ScreenUtils.calculateScreenWidth(activity)

        IntentIntegrator.forSupportFragment(this).initiateScan()
    }

    private fun setAdapter() {
        binding.cardsList.run {
            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.HORIZONTAL, false)
            adapter = CardsAdapter(viewModel.getCards()).also {
                it.setClickListener(this@AddCardFragment)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        setAdapter()

        IntentIntegrator.parseActivityResult(requestCode, resultCode, data)?.let {
            binding.code.text = it.contents ?: "ERROR"
            generateBarcodeImage(it.contents)
        } ?: super.onActivityResult(requestCode, resultCode, data)
    }

    private fun generateBarcodeImage(content: String) {
        val size = binding.barcode.width
        try {
            BarcodeEncoder().encodeBitmap(content, BarcodeFormat.EAN_13, size, size / 2).let {
                viewModel.saveBarcode(it, content)
                binding.barcode.setImageBitmap(it)
            }
        } catch (e: Exception) {
        }
    }

    override fun onItemClick(card: Card) {
        viewModel.saveCard(card)
    }
}