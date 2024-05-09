package com.example.pokeapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pokeapp.R
import com.example.pokeapp.ui.fragment.CalculatorFragment
import com.example.pokeapp.ui.fragment.PokedexFragment
import com.example.pokeapp.ui.fragment.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContentActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)



        //  RECYCLERVIEW CONTENT



        //  NAVIGATION OPTIONS

        //  variables that contain data from fragments in project
        val pokedexFragment = PokedexFragment()
        val userFragment = UserFragment()
        val calculatorFragment = CalculatorFragment()

        bottomNavigationView = findViewById(R.id.bottomBar)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.optionUser -> {
                    replaceFragment(UserFragment())
                    true
                }

                R.id.optionPokedex -> {
                    replaceFragment(PokedexFragment())
                    true
                }

                R.id.optionCalculator -> {
                    replaceFragment(CalculatorFragment())
                    true
                }

                else -> false
            }
        }

        replaceFragment(PokedexFragment())
        bottomNavigationView!!.selectedItemId = R.id.optionPokedex
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.framelayoutDisplay, fragment).commit()
    }
}