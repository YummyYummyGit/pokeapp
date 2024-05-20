package com.example.pokeapp.ui.contract

import com.example.pokeapp.data.model.Pokemon

interface PokedexContract {
    interface View {
        fun showPokemonList(pokemonList: List<Pokemon>)
        fun showError(message: String)
    }

    interface Presenter {
        fun loadPokemonList()
    }
}