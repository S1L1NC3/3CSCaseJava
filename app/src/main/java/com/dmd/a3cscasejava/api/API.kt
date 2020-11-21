package com.dmd.a3cscasejava.api

import PokemonsResponse
import com.dmd.a3cscasejava.models.PokemonDetailResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface API {
    @GET("pokemon")
    fun getPokemons(): Single<PokemonsResponse>

    @GET("pokemon/{pokemonName}")
    fun getPokemonByName(@Path("pokemonName") pokemonName: String): Single<PokemonDetailResponse>
}