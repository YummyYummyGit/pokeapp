package com.example.pokeapp.data.remote.api

import com.example.pokeapp.data.model.PokeList
import com.example.pokeapp.data.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiCalls {
    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id:Int) : Call<Pokemon>

    @GET("pokemon")
    fun getPokemonList() : Call<PokeList>
}

