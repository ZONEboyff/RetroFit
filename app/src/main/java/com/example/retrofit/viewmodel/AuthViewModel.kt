package com.example.retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

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
        viewModelScope.launch {
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