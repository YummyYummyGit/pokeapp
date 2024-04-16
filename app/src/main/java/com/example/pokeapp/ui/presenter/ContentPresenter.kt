package com.example.pokeapp.ui.presenter

import android.content.Context
import com.example.pokeapp.ui.contract.ContentContract
import com.example.pokeapp.util.SharedPreferencesConnector

class ContentPresenter (
    private val view: ContentContract.View,
    private val context: Context

) : ContentContract.Presenter {
    private val connector = SharedPreferencesConnector.getInstance(context)
    override fun getPokemonById() {
        TODO("Not yet implemented")
    }
}