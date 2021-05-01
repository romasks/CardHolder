package com.romasks.cardholder.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.romasks.cardholder.data.datasource.db.entities.Card
import com.romasks.cardholder.databinding.ItemCardBinding

class CardsAdapter(cards: List<Card>) : RecyclerView.Adapter<CardsAdapter.CardHolder>() {

    private lateinit var listener: ItemClickListener
    private val items: List<Card> = cards

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return CardHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class CardHolder(
        private val binding: ItemCardBinding,
        private val listener: ItemClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {
            with(binding) {
                cardName.text = card.name

                val resize = false
                if (resize) {
                    /*cardImage.setImageBitmap(
                        ImageUtils.getTransformedBitmap(root.resources, card.imageRes)
                    )*/
                } else {
                    Glide.with(root).load(card.image).into(cardImage)
//                    cardImage.setImageResource(card.imageRes)
                }

                root.setOnClickListener {
                    // listener.onItemClick(it, adapterPosition)
                    listener.onItemClick(card)
                }
            }
        }
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        listener = itemClickListener
    }

    interface ItemClickListener {
        // fun onItemClick(view: View?, position: Int)
        fun onItemClick(card: Card)
    }
}