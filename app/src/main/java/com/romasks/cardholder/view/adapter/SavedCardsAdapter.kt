package com.romasks.cardholder.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.romasks.cardholder.R
import com.romasks.cardholder.databinding.ItemSavedCardBinding
import com.romasks.cardholder.domain.entity.SavedCard

class SavedCardsAdapter(private val itemClickAction: (SavedCard) -> Unit) :
    RecyclerView.Adapter<SavedCardsAdapter.SavedCardHolder>() {

    private val items = arrayListOf<SavedCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSavedCardBinding.inflate(inflater, parent, false)
        return SavedCardHolder(binding, itemClickAction)
    }

    override fun onBindViewHolder(holder: SavedCardHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class SavedCardHolder(
        private val binding: ItemSavedCardBinding,
        private val itemClickAction: (SavedCard) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: SavedCard) {
            with(binding) {
                Log.d("BARCODE", card.toString())

                cardName.text = card.cardName
                card.cardBitmap
                    ?.let { cardImage.load(card.cardBitmap) }
                    ?: cardImage.load(R.drawable.card_example)

                root.setOnClickListener { itemClickAction(card) }
            }
        }
    }

    fun setItems(cards: List<SavedCard>?) {
        cards?.let { items.addAll(it) } ?: items.clear()
        notifyDataSetChanged()
    }
}