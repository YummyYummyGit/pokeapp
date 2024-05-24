package com.example.pokeapp.ui.contract

import com.example.pokeapp.data.model.Pokemon

interface PokedexContract {
    interface View {
        fun showPokemonList(pokemonList: List<Pokemon>)
        fun showError(message: String)
//      fun showDialogInfo(pokemon: Pokemon)
    }

    interface Presenter {
        fun loadPokemonList()
//      fun triggerDialogInfo(pokemon: Pokemon)
    }
}