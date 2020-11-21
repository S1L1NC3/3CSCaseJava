package com.dmd.a3cscasejava.viewHolder

import Pokemon
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmd.a3cscasejava.R

class PokemonsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_pokemon, parent, false)) {
    private var mTitleView: TextView? = null

    init {
        mTitleView = itemView.findViewById(R.id.txtItemPokemon)
    }

    fun bind(pokemon: Pokemon) {
        mTitleView?.text = pokemon.name
    }

}