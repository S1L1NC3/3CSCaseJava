package com.dmd.a3cscasejava.api

import PokemonsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface API {
    @GET("pokemon")
    fun getPokemons(): Single<PokemonsResponse>

}