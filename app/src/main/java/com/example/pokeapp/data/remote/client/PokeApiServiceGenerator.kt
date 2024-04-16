package com.example.pokeapp.data.remote.client

import androidx.lifecycle.MutableLiveData
import com.example.pokeapp.data.model.Pokemon
import com.example.pokeapp.data.remote.api.PokeApiCalls
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeApiServiceGenerator {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokeApiCalls = retrofit.create(PokeApiCalls::class.java)

    val pokemonInfo = MutableLiveData<Pokemon>()
    val pokemonSpriteUrl = MutableLiveData<String>()

    fun getPokemonById(id: Int){
        val call = service.getPokemonById(id)

        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                    pokemonSpriteUrl.postValue(pokemon.sprites.frontDefault)
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                call.cancel()
            }
        })
    }
}