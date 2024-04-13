//package com.example.pokeapp
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.auth.FirebaseAuth
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class RegisterActivity : AppCompatActivity() {
//    private lateinit var auth: FirebaseAuth
//    private lateinit var userRegistration: UserRegistration
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)
//
//        auth = FirebaseAuth.getInstance()
//        userRegistration = UserRegistration(auth)
//
//        //replace(R.id.email,password,username) with the ids from register.xml
//        val emailEditText = findViewById<EditText>(R.id.email)//replace with the ids from register.xml
//        val passwordEditText = findViewById<EditText>(R.id.password)
//        val usernameEditText = findViewById<EditText>(R.id.username)
//        val registerButton = findViewById<Button>(R.id.btn_register)
//
//        registerButton.setOnClickListener {
//            val email = emailEditText.text.toString()
//            val password = passwordEditText.text.toString()
//            val username = usernameEditText.text.toString()
//
//            CoroutineScope(Dispatchers.IO).launch {
//                try {
//                    val user = userRegistration.registerUser(email, password, username)
//                    // Handle successful registration
//                } catch (e: UserRegistrationException) {
//                    // Handle registration error
//                }
//            }
//        }
//    }
//}