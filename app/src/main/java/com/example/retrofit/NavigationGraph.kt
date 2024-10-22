package com.example.retrofit

import DateOfBirthScreen
import FitnessStatusScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.retrofit.screen.Screen
import com.example.retrofit.screen.bottom.MainView
import com.example.retrofit.screen.setup.LandingScreen
import com.example.retrofit.screen.setup.LoginScreen
import com.example.retrofit.screen.setup.ResetPasswordScreen
import com.example.retrofit.screen.setup.SignUpScreen
import com.example.retrofit.screen.setup.SplashScreen
import com.example.retrofit.screen.userdetails.GenderScreen
import com.example.retrofit.screen.userdetails.UserMetricsScreen
import com.example.retrofit.viewmodel.AuthViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.SetupDetail.SplashScreen.route
    ) {
        composable(Screen.SetupDetail.SplashScreen.route) {
            SplashScreen { isUserSignedIn ->
                    navController.navigate(Screen.BottomScreen.Home.bRoute) {
                        // Clear the back stack to prevent going back to the splash screen

                }
            }
        }
        composable(Screen.SetupDetail.LandingScreen.route) {
            LandingScreen {
                navController.navigate(Screen.SetupDetail.LogInScreen.route) {
                    popUpTo(Screen.SetupDetail.LandingScreen.route) { inclusive = true }
                }
            }
        }
        composable(Screen.SetupDetail.LogInScreen.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onLogIn = {
                    navController.navigate(Screen.GetUserDetail.GenderScreen.route) {
                        popUpTo(Screen.SetupDetail.LogInScreen.route) { inclusive = true }
                    }
                },
                onSignUp = {
                    navController.navigate(Screen.SetupDetail.SignUpScreen.route) {
                        popUpTo(Screen.SetupDetail.LogInScreen.route) { inclusive = true }
                    }
                },
                onForgotPassword = {
                    navController.navigate(Screen.SetupDetail.ForgotPasswordScreen.route)
                }
            )
        }
        composable(Screen.SetupDetail.SignUpScreen.route) {
            SignUpScreen(
                onBackClicked = { navController.popBackStack() },
                authViewModel = authViewModel
            )
        }
        composable(Screen.SetupDetail.ForgotPasswordScreen.route) {
            ResetPasswordScreen(
                onBackClicked = { navController.navigate(Screen.SetupDetail.LogInScreen.route) {
                    popUpTo(Screen.SetupDetail.ForgotPasswordScreen.route) { inclusive = true }
                }},
                authViewModel = authViewModel
            )
        }
        composable(Screen.GetUserDetail.GenderScreen.route) {
            GenderScreen(
                onBackClicked = { navController.popBackStack() },
                onNextClicked = {
                    selectedGender->
                    authViewModel.updateGender(selectedGender)
                    navController.navigate(Screen.GetUserDetail.UserMetricsScreen.route)
                }
            )
        }
        composable(Screen.GetUserDetail.UserMetricsScreen.route) {
            UserMetricsScreen(
                onBackClicked = { navController.popBackStack() },
                onNextClicked = {height,weight->
                    authViewModel.updateHeight(height)
                    authViewModel.updateWeight(weight)
                    navController.navigate(Screen.GetUserDetail.BirthdateScreen.route)
                }
            )
        }
        composable(Screen.GetUserDetail.BirthdateScreen.route) {
            DateOfBirthScreen(
                onBackClicked = { navController.popBackStack() },
                onNextClicked = {
                    birthdate->
                    authViewModel.updateDateOfBirth(birthdate)
                    navController.navigate(Screen.GetUserDetail.FitnessLevelScreen.route)
                }
            )
        }
        composable(Screen.GetUserDetail.FitnessLevelScreen.route) {
            FitnessStatusScreen(
                onBackClicked = { navController.popBackStack() },
                onDoneClicked = {
                    fitnessLevel->
                    authViewModel.updateFitnessLevel(fitnessLevel)
                    authViewModel.saveCollectedFitnessDetails()
                    navController.navigate(Screen.BottomScreen.Home.bRoute) {
                        popUpTo(Screen.GetUserDetail.FitnessLevelScreen.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.BottomScreen.Home.bRoute) {
           MainView()
        }
    }
}