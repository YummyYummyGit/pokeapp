package com.example.pokeapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapp.R
import com.example.pokeapp.util.UserRegistration
import com.example.pokeapp.util.UserRegistrationException
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var userRegistration: UserRegistration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        auth = FirebaseAuth.getInstance()
        userRegistration = UserRegistration(auth)

        val emailEditText = findViewById<EditText>(R.id.textfield_email)
        val passwordEditText = findViewById<EditText>(R.id.textfield_password)
        val usernameEditText = findViewById<EditText>(R.id.textfield_user)
        val registerButton = findViewById<Button>(R.id.register_btn_register)

        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val username = usernameEditText.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val user = userRegistration.registerUser(email, password, username)
                    // Handle successful registration
                    // Navigate to LoginActivity
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                } catch (e: UserRegistrationException) {
                    // Handle registration error
                }
            }
        }
    }
}