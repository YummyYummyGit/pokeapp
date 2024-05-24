package com.example.pokeapp.data.model

data class Pokemon (
    val name: String,
    val id: Int,
    val types: List<PokemonType>,
    val url: String,
    val imageUrl: String
)

data class Type (
    val name: String
)

data class PokemonType (
    val type: Type
)