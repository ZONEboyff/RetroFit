package com.example.retrofit

import DateOfBirthScreen
import FitnessStatusScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.retrofit.screen.setup.LandingScreen
import com.example.retrofit.screen.Screen
import com.example.retrofit.screen.setup.ResetPasswordScreen
import com.example.retrofit.screen.setup.LoginScreen
import com.example.retrofit.screen.setup.SignUpScreen
import com.example.retrofit.screen.setup.SplashScreen
import com.example.retrofit.screen.userdetails.GenderScreen
import com.example.retrofit.screen.userdetails.HomeScreen
import com.example.retrofit.screen.userdetails.UserMetricsScreen
import com.example.retrofit.ui.theme.RetroFitTheme
import com.example.retrofit.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val authViewModel: AuthViewModel = viewModel()
            RetroFitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationGraph(navController=navController,modifier = Modifier.padding(innerPadding),authViewModel = authViewModel)
                }
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier,authViewModel: AuthViewModel){
    NavHost(
        navController = navController,
        startDestination = Screen.SetupDetail.SplashScreen.route
    ){
        composable(Screen.SetupDetail.SplashScreen.route){
            SplashScreen {
                navController.navigate(Screen.SetupDetail.LandingScreen.route)
            }
        }
        composable(Screen.SetupDetail.LandingScreen.route){
            LandingScreen {
                navController.navigate(Screen.SetupDetail.LogInScreen.route)
            }
        }
        composable(Screen.SetupDetail.LogInScreen.route){
            LoginScreen(
                authViewModel = authViewModel,
                onLogIn = { navController.navigate((Screen.GetUserDetail.GenderScreen.route))},
                onSignUp = { navController.navigate((Screen.SetupDetail.SignUpScreen.route))},
                onForgotPassword = {navController.navigate((Screen.SetupDetail.ForgotPasswordScreen.route))}
            )
        }
        composable(Screen.SetupDetail.SignUpScreen.route){
            SignUpScreen(
                onBackClicked = {navController.popBackStack()},
                authViewModel = authViewModel
            )
        }
        composable(Screen.SetupDetail.ForgotPasswordScreen.route){
            ResetPasswordScreen(
                onBackClicked = {navController.navigate((Screen.SetupDetail.LogInScreen.route))},
                authViewModel = authViewModel
            )
        }
        composable(Screen.GetUserDetail.GenderScreen.route){
            GenderScreen(
                onBackClicked = {navController.popBackStack()},
                onNextClicked = {navController.navigate((Screen.GetUserDetail.UserMetricsScreen.route))}
            )
        }
        composable(Screen.GetUserDetail.UserMetricsScreen.route){
            UserMetricsScreen(
                onBackClicked = {navController.popBackStack()},
                onNextClicked = {navController.navigate((Screen.GetUserDetail.BirthdateScreen.route))}
            )
        }
        composable(Screen.GetUserDetail.BirthdateScreen.route){
            DateOfBirthScreen(
                onBackClicked = {navController.popBackStack()},
                onNextClicked = {navController.navigate((Screen.GetUserDetail.FitnessLevelScreen.route))}
            )

        }
        composable(Screen.GetUserDetail.FitnessLevelScreen.route){
            FitnessStatusScreen(
                onBackClicked = {navController.popBackStack()},
                onDoneClicked = {navController.navigate((Screen.BottomScreen.HomeScreen.route))}
            )
        }
        composable(Screen.BottomScreen.HomeScreen.route){
            HomeScreen()
        }
    }
}