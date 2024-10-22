package com.example.retrofit.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.retrofit.data.Exercise
import com.example.retrofit.data.getStrengthExercises

class PlanViewModel : ViewModel() {

    // Map to store exercises for each day, initially empty
    val exercisesByDay = mutableStateOf(
        mutableMapOf(
            "Monday" to getStrengthExercises(),
            "Tuesday" to mutableListOf<Exercise>(),
            "Wednesday" to mutableListOf<Exercise>(),
            "Thursday" to mutableListOf<Exercise>(),
            "Friday" to mutableListOf<Exercise>(),
            "Saturday" to mutableListOf<Exercise>(),
            "Sunday" to mutableListOf<Exercise>()
        )
    )

    // Function to add exercise to a specific day
    fun addExerciseToDay(day: String, exercise: Exercise) {
        // Create a new mutable list to hold current exercises
        val currentExercises = exercisesByDay.value[day]?.toMutableList() ?: mutableListOf()

        // Add the new exercise to the list
        currentExercises.add(exercise)

        // Log for debugging purposes
        Log.d("PlanViewModel", "New exercises for $day: $currentExercises")

        // Create a new map and update the state with a new reference to the updated day
        exercisesByDay.value = exercisesByDay.value.toMutableMap().apply {
            this[day] = currentExercises
        }
    }

    // Function to remove an exercise from a specific day
    fun removeExerciseFromDay(day: String, exercise: Exercise) {
        // Create a new mutable list to hold current exercises
        val currentExercises = exercisesByDay.value[day]?.toMutableList() ?: mutableListOf()

        // Remove the exercise
        currentExercises.remove(exercise)

        // Update the state with a new reference to the updated day
        exercisesByDay.value = exercisesByDay.value.toMutableMap().apply {
            this[day] = currentExercises
        }
    }
}
