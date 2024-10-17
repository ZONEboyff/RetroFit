package com.example.retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.AuthResult
import com.example.retrofit.data.FitnessDetails
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    // FitnessDetails object that will be updated as data is collected
    private var fitnessDetails: FitnessDetails = FitnessDetails()

    // Update methods to collect fitness details one by one
    fun updateHeight(height: String) {
        fitnessDetails = fitnessDetails.copy(height = height)
    }

    fun updateWeight(weight: String) {
        fitnessDetails = fitnessDetails.copy(weight = weight)
    }

    fun updateGender(gender: String) {
        fitnessDetails = fitnessDetails.copy(gender = gender)
    }

    fun updateFitnessLevel(fitnessLevel: Float) {
        fitnessDetails = fitnessDetails.copy(fitnessLevel = fitnessLevel)
    }

    fun updateDateOfBirth(dateOfBirth: String) {
        fitnessDetails = fitnessDetails.copy(dateOfBirth = dateOfBirth)
    }

    // Once all details are collected, call this to save them to Firestore
    fun saveCollectedFitnessDetails() {
        val userId = auth.currentUser?.uid
        if (userId != null) {
            saveFitnessDetails(userId, fitnessDetails)
        }
    }

    // Function to save fitness details in Firestore
    private fun saveFitnessDetails(userId: String, fitnessDetails: FitnessDetails) {
        val userRef = db.collection("users").document(userId)

        userRef.set(fitnessDetails)
            .addOnSuccessListener {
                Log.d("Firestore", "Fitness details successfully saved!")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error saving fitness details", e)
            }
    }



    fun signUp(email: String, name: String, password: String, callback: (AuthResult) -> Unit) {
        viewModelScope.launch {
            try {
                val userCredential = auth.createUserWithEmailAndPassword(email, password).await()
                // Optionally set the display name
                userCredential.user?.updateProfile(
                    com.google.firebase.auth.UserProfileChangeRequest.Builder().setDisplayName(name).build()
                )
                // Send verification email
                userCredential.user?.sendEmailVerification()?.await()
                callback(AuthResult.Success)
            } catch (e: FirebaseAuthWeakPasswordException) {
                callback(AuthResult.Error("The password is too weak."))
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                callback(AuthResult.Error("The email format is incorrect."))
            } catch (e: FirebaseAuthUserCollisionException) {
                callback(AuthResult.Error("This email is already registered."))
            } catch (e: FirebaseAuthException) {
                callback(AuthResult.Error("Authentication failed: ${e.localizedMessage}"))
            } catch (e: Exception) {
                callback(AuthResult.Error("Unknown error: ${e.localizedMessage}"))
            }
        }
    }

    fun login(email: String, password: String, callback: (AuthResult) -> Unit) {
        viewModelScope.launch {
            try {
                val userCredential = auth.signInWithEmailAndPassword(email, password).await()
                val user = auth.currentUser
                if (user != null && user.isEmailVerified) {
                    callback(AuthResult.Success)
                } else {
                    // User is not verified or doesn't exist
                    callback(AuthResult.Error("Email not verified or user doesn't exist."))
                }
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                callback(AuthResult.Error("Invalid credentials."))
            } catch (e: FirebaseAuthException) {
                callback(AuthResult.Error("Authentication failed: ${e.localizedMessage}"))
            } catch (e: Exception) {
                callback(AuthResult.Error("Unknown error: ${e.localizedMessage}"))
            }
        }
    }


    fun resetPassword(email: String, callback: (AuthResult) -> Unit) {
        viewModelScope.launch  {
            try {
                auth.sendPasswordResetEmail(email).await()
                callback(AuthResult.Success)
            } catch (e: FirebaseAuthInvalidUserException) {
                callback(AuthResult.Error("No user found with this email."))
            } catch (e: FirebaseAuthInvalidCredentialsException) {
                callback(AuthResult.Error("The email format is incorrect."))
            } catch (e: FirebaseAuthException) {
                callback(AuthResult.Error("Error sending reset email: ${e.localizedMessage}"))
            } catch (e: Exception) {
                callback(AuthResult.Error("Unknown error: ${e.localizedMessage}"))
            }
        }
    }
    fun signInWithGoogle(idToken: String, callback: (AuthResult) -> Unit) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential).await()
                callback(AuthResult.Success)
            } catch (e: FirebaseAuthException) {
                callback(AuthResult.Error("Google Sign-In failed: ${e.localizedMessage}"))
            }
        }
    }


}