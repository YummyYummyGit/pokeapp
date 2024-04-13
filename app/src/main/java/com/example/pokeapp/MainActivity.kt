package com.example.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat

/* import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

private lateinit var auth: FirebaseAuth */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content)

        // Note: These variables will carry the content of "com.example.pokeapp > fm_dex / fm_user"
        val fragmentPokedex = fm_dex()
        val fragmentUser = fm_user()

        val btnPokedex = findViewById<Button>(R.id.content_btn_dex)
        val btnUser = findViewById<Button>(R.id.content_btn_user)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.content_fl_display, fragmentPokedex)
            commit()
        }

        // Note: To give "content_btn_dex" functionality, we need to build the following method
        btnPokedex.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                // This line tells us that, in the FrameLayout located in "res > layout > content", the content of the Pokédex Fragment will be displayed
                replace(R.id.content_fl_display, fragmentPokedex)
                // When we click the back arrow in the phone, we will be returned to the previous page
                addToBackStack(null)
                // In order to perform the transition from screen to screen, we need to commit the change
                commit()
            }
        }

        btnUser.setOnClickListener() {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.content_fl_display, fragmentUser)
                addToBackStack(null)
                commit()
            }
        }

//        // setContentView(R.layout.start)
//        // auth = Firebase.auth
//        val crashButton = Button(this)
//        crashButton.text="Test Crash"
//        crashButton.setOnClickListener{
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//
//        addContentView(crashButton, ViewGroup.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        ))
    }
}