package com.dmd.a3cscasejava.adapters

import Pokemon
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmd.a3cscasejava.viewHolder.PokemonsViewHolder

class PokemonsAdapter(private val dataList: ArrayList<Pokemon>): RecyclerView.Adapter<PokemonsViewHolder>() {
    private var onPokemonItemClickListener: OnPokemonItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PokemonsViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: PokemonsViewHolder, position: Int) {
        val pokemon: Pokemon = dataList[position]
        holder.bind(pokemon)
        holder.itemView.setOnClickListener {
            onPokemonItemClickListener?.itemPokemonItemClick(pokemon)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateList(newDataList: ArrayList<Pokemon>) {
        dataList.clear()
        dataList.addAll(newDataList)
        notifyDataSetChanged()
    }

    fun setOnPokemonItemClickListener(listener: OnPokemonItemClickListener) {
        onPokemonItemClickListener = listener
    }

    interface OnPokemonItemClickListener {
        fun itemPokemonItemClick(pokemon: Pokemon)
    }
}