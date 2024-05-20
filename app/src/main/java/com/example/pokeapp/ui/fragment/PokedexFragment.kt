package com.example.pokeapp.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeapp.R
import com.example.pokeapp.data.model.Pokemon
import com.example.pokeapp.data.remote.client.PokeApiServiceGenerator
import com.example.pokeapp.ui.contract.PokedexContract

class PokedexFragment : Fragment(), PokedexContract.View {

    private lateinit var presenter: PokedexContract.Presenter
    private lateinit var adapter: PokemonAdapter
    private lateinit var pokedexRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokedexRecyclerView = view.findViewById(R.id.pokedexRecyclerView)
        pokedexRecyclerView.layoutManager = LinearLayoutManager(context)

        val apiService = PokeApiServiceGenerator().service
        presenter = PokedexPresenter(this, apiService)

        presenter.loadPokemonList()
    }

    override fun showPokemonList(pokemonList: List<Pokemon>) {
        adapter = PokemonAdapter(pokemonList)
        pokedexRecyclerView.adapter = adapter
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
}
