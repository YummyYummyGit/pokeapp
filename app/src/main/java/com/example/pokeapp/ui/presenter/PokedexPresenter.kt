// PokedexPresenter.kt
package com.example.pokeapp.ui.pokedex

import com.example.pokeapp.data.model.PokeList
import com.example.pokeapp.data.remote.api.PokeApiCalls
import com.example.pokeapp.ui.contract.PokedexContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokedexPresenter(private val view: PokedexContract.View, private val api: PokeApiCalls) : PokedexContract.Presenter {

    override fun loadPokemonList() {
        val call = api.getPokemonList()
        call.enqueue(object : Callback<PokeList> {
            override fun onResponse(call: Call<PokeList>, response: Response<PokeList>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        view.showPokemonList(it.results)
                    } ?: run {
                        view.showError("Empty response")
                    }
                } else {
                    view.showError("Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PokeList>, t: Throwable) {
                view.showError("Failed to load data: ${t.message}")
            }
        })
    }
}
