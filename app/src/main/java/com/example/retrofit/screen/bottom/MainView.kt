package com.example.retrofit.screen.bottom

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.retrofit.screen.Screen
import com.example.retrofit.screen.bottom.Plan.ExerciseScreen
import com.example.retrofit.screen.bottom.Plan.PlanScreen
import com.example.retrofit.screen.bottom.Plan.TypeSelectionScreen
import com.example.retrofit.screen.main.MealNavigate
import com.example.retrofit.screen.main.progressNavigate
import com.example.retrofit.screen.screensInBottom
import com.example.retrofit.viewmodel.PlanViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainView() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF2C0926),
            ) {
                screensInBottom.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.bRoute,
                        onClick = {
                            navController.navigate(item.bRoute) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(painter = painterResource(id = item.icon), contentDescription = item.bTitle)
                        },
                        label = {
                            Text(text = item.bTitle)
                        },
                    )
                }
            }
        }
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    var planViewModel:PlanViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.BottomScreen.Home.bRoute) {
        composable(Screen.BottomScreen.Home.route) {
            HomeScreen()
        }
        composable(Screen.BottomScreen.Plan.bRoute) {
            PlanScreen(
                onAddClicked = {
                    navController.navigate(Screen.BottomScreen.Plan.TypeSelectionScreen.route)
                },
                planViewModel = planViewModel
            )
        }

        // Type Selection Screen (Cardio or Strength)
        composable(Screen.BottomScreen.Plan.TypeSelectionScreen.route) {
            TypeSelectionScreen(
                onBackClicked = {
                    navController.popBackStack()
                },
                onTypeSelected = { isCardio ->   // Boolean value passed (true = cardio, false = strength)
                    navController.navigate(
                        Screen.BottomScreen.Plan.ExerciseScreen.route + "/$isCardio"
                    )
                }
            )
        }

        // Exercise Screen (based on type selection)
        composable(
            route = Screen.BottomScreen.Plan.ExerciseScreen.route + "/{exerciseType}",
        ) { backStackEntry ->
            val exerciseType = backStackEntry.arguments?.getBoolean("exerciseType")
            ExerciseScreen(
                exerciseType = exerciseType ?: false,
                onExerciseSelected = { selectedDay,exercise ->
                    planViewModel.addExerciseToDay(selectedDay, exercise)
                    navController.popBackStack(Screen.BottomScreen.Plan.bRoute, false)  // Go back after adding
                }
            )
        }
        composable(Screen.BottomScreen.Meal.route) {
            MealNavigate()
        }
        composable(Screen.BottomScreen.Progress.route) {
            progressNavigate()
        }
        composable(Screen.BottomScreen.Profile.route) {
            com.example.retrofit.screen.main.ProfileScreen()
        }
    }
}