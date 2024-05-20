package com.example.pokeapp.ui.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.data.model.Pokemon
import com.bumptech.glide.Glide

class PokemonAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonName: TextView = view.findViewById(R.id.pokeName)
        val pokemonId: TextView = view.findViewById(R.id.pokeId)
        val pokemonImage: ImageView = view.findViewById(R.id.pokeImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poketag, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.pokemonName.text = pokemon.name
        holder.pokemonId.text = "#${position + 1}"

        Glide.with(holder.itemView.context)
            .load(pokemon.imageUrl)
            .placeholder(R.drawable.bg_pikachu)
            .error(R.drawable.bg_pikachu)
            .into(holder.pokemonImage)
    }

    override fun getItemCount() = pokemonList.size
}
