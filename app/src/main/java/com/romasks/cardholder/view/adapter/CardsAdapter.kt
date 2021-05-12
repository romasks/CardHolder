package com.romasks.cardholder.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.romasks.cardholder.databinding.ItemCardBinding
import com.romasks.cardholder.domain.entity.Card

class CardsAdapter(private val itemClickAction: (Card) -> Unit) :
    RecyclerView.Adapter<CardsAdapter.CardHolder>() {

    private val items = arrayListOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return CardHolder(binding, itemClickAction)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class CardHolder(
        private val binding: ItemCardBinding,
        private val itemClickAction: (Card) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {
            with(binding) {
                Log.d("CARD", card.toString())

                cardName.text = card.name
                card.bitmap
                    ?.let { cardImage.load(card.bitmap) }
                    ?: cardImage.load(card.imageUrl)

                root.setOnClickListener { itemClickAction(card) }
            }
        }
    }

    fun setItems(cards: List<Card>?) {
        cards?.let { items.addAll(it) } ?: items.clear()
        notifyDataSetChanged()
    }
}