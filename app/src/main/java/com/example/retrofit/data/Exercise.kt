package com.example.retrofit.data

import com.example.retrofit.R
import kotlin.time.Duration

data class Exercise(
    val name: String,
    val description: String,
    val duration: String,
    val caloriesBurned: String,
    val imageResId: Int
)

fun getCardioExercises(): List<Exercise> {
    return listOf(
        Exercise(
            name = "Running",
            description = "Running is a high-impact cardiovascular exercise that strengthens your heart, lungs, and muscles while burning a significant number of calories.",
            duration = "30 minutes",
            caloriesBurned = "140 Cal/Mile",
            imageResId = R.drawable.lifting_image // Replace with actual resource ID for running
        ),
        Exercise(
            name = "Swimming",
            description = "Swimming is an excellent low-impact workout that improves endurance and muscle strength.",
            duration = "1 hour",
            caloriesBurned = "500 Cal/Hour",
            imageResId = R.drawable.strength // Replace with actual resource ID for swimming
        ),
        Exercise(
            name = "Cycling",
            description = "Cycling is a low-impact exercise that helps in improving cardiovascular fitness and leg strength.",
            duration = "45 minutes",
            caloriesBurned = "300 Cal/Hour",
            imageResId = R.drawable.strength // Replace with actual resource ID for cycling
        )
        // Add more cardio exercises as needed
    )
}

fun getStrengthExercises(): List<Exercise> {
    return listOf(
        Exercise(
            name = "Deadlift",
            description = "Deadlifts work several muscle groups at once and improve overall strength.",
            duration = "30 minutes",
            caloriesBurned = "200 Cal/30min",
            imageResId = R.drawable.lifting_image // Replace with actual resource ID for deadlift
        ),
        Exercise(
            name = "Squats",
            description = "Squats are a fundamental exercise to strengthen legs and core.",
            duration = "30 minutes",
            caloriesBurned = "160 Cal/30min",
            imageResId = R.drawable.lifting_image // Replace with actual resource ID for squats
        ),
        Exercise(
            name = "Bench Press",
            description = "Bench Press is an essential strength training exercise for upper body strength.",
            duration = "30 minutes",
            caloriesBurned = "200 Cal/30min",
            imageResId = R.drawable.cardio // Replace with actual resource ID for bench press
        )
        // Add more strength exercises as needed
    )
}

