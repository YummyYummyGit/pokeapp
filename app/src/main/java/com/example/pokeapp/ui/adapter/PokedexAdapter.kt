package com.example.pokeapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.data.model.Pokemon

class PokedexAdapter(private val pokemon: List<Pokemon>) : RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        val view =LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_pokedex, parent, false)
        return PokedexViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {
        val pokemon = pokemon[position]
        holder.bind(pokemon)
    }

    class PokedexViewHolder (view : View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.pokeName)
        val id: TextView = view.findViewById(R.id.pokeId)
        val image: ImageView = view.findViewById(R.id.pokeImage)

        fun bind(pokemon: Pokemon) {
            name.text = pokemon.name
//            id.toString(val number) = pokemon.number
//            image.image = pokemon.image

        }
    }
}