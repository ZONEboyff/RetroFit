package com.example.retrofit.screen.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofit.screen.Screen

@Composable
fun progressNavigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "progressScreen") {
        composable("progressScreen") {
            ProgressScreen(onStepScreen = {navController.navigate("stepsScreen")})
        }
        composable("stepsScreen") {
            StepsGraphScreen()
        }
    }
}