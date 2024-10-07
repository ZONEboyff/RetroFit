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
