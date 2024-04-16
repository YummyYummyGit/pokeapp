package com.example.pokeapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.pokeapp.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize FirebaseApp before calling any Firebase methods
        FirebaseApp.initializeApp(this)

        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        setContentView(R.layout.start)

        // Now you can get an instance of FirebaseAuth
        auth = FirebaseAuth.getInstance()

        val crashButton = Button(this)
        crashButton.text="Test Crash"
        crashButton.setOnClickListener{
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ))

        val registerButton = findViewById<Button>(R.id.start_btn_register)

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val loginButton = findViewById<Button>(R.id.start_btn_login)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}