package com.example.pokeapp.ui.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapp.R
import com.example.pokeapp.ui.fragments.PokedexFragment
import com.example.pokeapp.ui.fragments.UserFragment

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        //  variables contain data of "ui > fragments > PokedexFragment / UserFragment"
        val pokedexFragment = PokedexFragment()
        val userFragment = UserFragment()

        //  variables carry the id of buttons located in "content.xml"
        val pokedexButton = findViewById<Button>(R.id.buttonPokedex)
        val userButton = findViewById<Button>(R.id.buttonUser)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayoutDisplay, pokedexFragment)
            commit()
        }

        //  set an action to button "buttonPokedex" in "content.xml"
        pokedexButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                // in "framelayoutDisplay" located in "content.xml", we tell the framelayout that it has to display the content in "pokedex_fragment.xml"
                replace(R.id.framelayoutDisplay, pokedexFragment)
                addToBackStack(null)
                commit()
            }
        }

        userButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.framelayoutDisplay, userFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}