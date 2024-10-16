package com.example.retrofit.screen.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MealNavigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "MealScreen") {
        composable("MealScreen") {
            MealMainScreen { navController.navigate("IngredientScreen") }
        }
        composable("IngredientScreen") {
            MealRecipe { navController.navigate("ProcedureScreen") }
        }
        composable("ProcedureScreen") {
            RecipeProcedure { navController.popBackStack() }  // Navigate back to Ingredient screen
        }
    }
}