package com.example.pokeapp.data.model

data class PokeList(
    val count: Int,
    val next: String,
    val results: List<Pokemon>
)
