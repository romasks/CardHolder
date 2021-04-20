package com.romasks.cardholder.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        IntentIntegrator.forSupportFragment(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        IntentIntegrator.parseActivityResult(requestCode, resultCode, data)?.let {
            binding.tvBarcode.text = it.contents ?: "ERROR"
            generateBarcodeImage(it.contents)
        } ?: super.onActivityResult(requestCode, resultCode, data)
    }

    private fun generateBarcodeImage(content: String) {
        try {
            BarcodeEncoder().encodeBitmap(content, BarcodeFormat.EAN_13, 800, 300).let {
                binding.ivBarcode.setImageBitmap(it)
            }
        } catch (e: Exception) {
        }
    }
}