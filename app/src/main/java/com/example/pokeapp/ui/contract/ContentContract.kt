package com.example.pokeapp.ui.contract

interface ContentContract {
    interface View {
        fun showPokemon(name: String)
    }

    interface Presenter {
        fun getPokemonById()
    }
}