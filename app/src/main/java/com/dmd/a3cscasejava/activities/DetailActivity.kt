package com.dmd.a3cscasejava.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dmd.a3cscasejava.activities.MainActivity.Companion.EXTRAS_KEY
import com.dmd.a3cscasejava.adapters.AbilitiesAdapter
import com.dmd.a3cscasejava.databinding.ActivityDetailBinding
import com.dmd.a3cscasejava.models.PokemonDetailResponse

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var pokemonDetails: PokemonDetailResponse
    private lateinit var adapter : AbilitiesAdapter
    private var isSecond = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        if (intent.getSerializableExtra(EXTRAS_KEY) != null){
            pokemonDetails = intent.getSerializableExtra(EXTRAS_KEY) as PokemonDetailResponse //Key will be assigned to const
            fillViews(pokemonDetails)
        }
    }

    private fun fillViews(pokemonDetailResponse: PokemonDetailResponse){
        binding.txtPokemonName.text = pokemonDetailResponse.name
        binding.txtPokemonWeight.text = pokemonDetailResponse.weight.toString()
        adapter = AbilitiesAdapter(applicationContext , pokemonDetails.abilities)
        binding.listViewAbilities.adapter = adapter

        Glide.with(this@DetailActivity).load(pokemonDetailResponse.sprites.front_default).into(binding.imgPokemonSprite)

        binding.imgPokemonSprite.setOnClickListener {
            if (isSecond){
                Glide.with(this@DetailActivity).load(pokemonDetailResponse.sprites.front_default).into(binding.imgPokemonSprite)
            } else {
                Glide.with(this@DetailActivity).load(pokemonDetailResponse.sprites.back_default).into(binding.imgPokemonSprite)
            }
            isSecond = !isSecond
        }

    }




}