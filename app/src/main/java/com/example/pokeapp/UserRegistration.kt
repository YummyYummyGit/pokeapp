//package com.example.pokeapp
//
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
//import kotlinx.coroutines.tasks.await
//
//class UserRegistrationException(message: String) : Exception(message)
//
//class UserRegistration(private val auth: FirebaseAuth) {
//    private val db = FirebaseFirestore.getInstance()
//
//    suspend fun registerUser(email: String, password: String, username: String): User {
//        try {
//            // Register the user with Firebase Authentication
//            val result = auth.createUserWithEmailAndPassword(email, password).await()
//
//            // Create a User object
//            val user = User(result.user!!.uid, username, email, password)
//
//            // Create a document for the user in the "users" collection
//            db.collection("users").document(user.uid).set(user).await()
//
//            return user
//        } catch (e: Exception) {
//            throw UserRegistrationException(e.message ?: "An error occurred")
//        }
//    }
//}