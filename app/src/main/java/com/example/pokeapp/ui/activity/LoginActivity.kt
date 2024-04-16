package com.example.pokeapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokeapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        val usernameEditText = findViewById<EditText>(R.id.textfield_user)
        val passwordEditText = findViewById<EditText>(R.id.textfield_password)
        val loginButton = findViewById<Button>(R.id.button_login)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Look up the email corresponding to the provided username
            db.collection("usernameToEmail").document(username).get()
                .addOnSuccessListener { document: DocumentSnapshot ->
                    val email = document.getString("email")
                    if (email != null) {
                        // Use the retrieved email to authenticate with Firebase
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    val user = auth.currentUser
                                    Toast.makeText(baseContext, "Authentication Success.",
                                        Toast.LENGTH_SHORT).show()
                                    // Navigate to the ContentActivity
                                    val intent = Intent(this, ContentActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(baseContext, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        Toast.makeText(baseContext, "Username not found.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}