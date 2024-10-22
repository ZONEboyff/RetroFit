package com.example.retrofit.data

data class FitnessDetails(
    val height: String = "",
    val weight: String = "",
    val gender: String = "",
    val fitnessLevel: Float = 0f,
    val dateOfBirth: String = "" // Format: "YYYY-MM-DD"
)

