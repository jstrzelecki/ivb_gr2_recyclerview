package com.example.ivgr2recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val sweetsList: List<Sweets>,
    private val clickListener: (Sweets) -> Unit,

) : RecyclerView.Adapter<MyAdapter.SweetsViewHolder>(){

    class SweetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sweetName: TextView = itemView.findViewById(R.id.sweet_name)
        val sweetPrice: TextView = itemView.findViewById(R.id.sweet_price)
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

        holder.itemView.setOnClickListener {
            clickListener(currentSweet)
        }
    }
}