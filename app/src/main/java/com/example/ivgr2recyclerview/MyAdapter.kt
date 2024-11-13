package com.example.ivgr2recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val sweetsList: List<Sweets>,
    private val clickListener: (Sweets) -> Unit,

) : RecyclerView.Adapter<MyAdapter.SweetsViewHolder>(){

    class SweetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sweetName: TextView = itemView.findViewById(R.id.sweet_name)
        val sweetPrice: TextView = itemView.findViewById(R.id.sweet_price)
        val addToCartButton: Button = itemView.findViewById(R.id.add_to_cart_button)
        val favroriteButton: ImageButton = itemView.findViewById(R.id.favorite_imagebutton)
        val addToCartCounter: TextView = itemView.findViewById(R.id.add_to_cart_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SweetsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.list_item, parent, false)

        return SweetsViewHolder(itemView)
    }

    override fun getItemCount(): Int = sweetsList.size

    override fun onBindViewHolder(holder: SweetsViewHolder, position: Int) {
        val currentSweet = sweetsList[position] // dane
        holder.sweetPrice.text = "Cena ${currentSweet.price}" //widok
        holder.sweetName.text = currentSweet.name

        if(currentSweet.isFavorite){
            holder.favroriteButton.setImageResource(R.drawable.favorite)
        } else {
            holder.favroriteButton.setImageResource(R.drawable.favorite_border)
        }

        holder.addToCartCounter.text ="Dodano: ${currentSweet.addToCarCounter}"




        holder.itemView.setOnClickListener {
            clickListener(currentSweet)
        }

        holder.addToCartButton.setOnClickListener {
            Log.i("add", "dodano do koszyka ${currentSweet.name}")
            currentSweet.addToCarCounter += 1
            holder.addToCartCounter.text ="Dodano: ${currentSweet.addToCarCounter}"


        }

        holder.favroriteButton.setOnClickListener {
            currentSweet.isFavorite = !currentSweet.isFavorite
            notifyItemChanged(position)

        }
    }
}