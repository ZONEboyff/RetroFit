package com.example.retrofit.screen

import androidx.annotation.DrawableRes
import com.example.retrofit.R
import com.example.retrofit.screen.Screen.BottomScreen


sealed class Screen(val route:String) {
    object SetupDetail{
        object SplashScreen:Screen("splash_screen")
        object LandingScreen:Screen("landing_screen")
        object SignUpScreen:Screen("signup_screen")
        object LogInScreen:Screen("login_screen")
        object ForgotPasswordScreen:Screen("forgot_password_screen")
    }
    object GetUserDetail{
        object GenderScreen:Screen("gender_screen")
        object UserMetricsScreen:Screen("height_weight_screen")
        object BirthdateScreen:Screen("birthdate_screen")
        object FitnessLevelScreen:Screen("fitness_level_screen")
    }
    sealed class BottomScreen(val bTitle:String,val bRoute:String,@DrawableRes val icon: Int): Screen(bRoute){
        object Home : BottomScreen("Home","home", R.drawable.ic_home)
        object Plan : BottomScreen("Plan", "plan", R.drawable.ic_plan) {
            // Define routes for Plan feature
            object TypeSelectionScreen : Screen("type_selection_screen")
            object ExerciseScreen : Screen("exercise_screen/{exerciseType}") {
                fun createRoute(exerciseType: String) = "exercise_screen/$exerciseType"
            }
        }
        object Meal : BottomScreen("Meal","meals",R.drawable.ic_meal)
        object Progress : BottomScreen("Progress","progress",R.drawable.ic_progress)
        object Profile : BottomScreen("Profile","profile",R.drawable.ic_profile)
    }
}
val screensInBottom = listOf(
    BottomScreen.Home,
    BottomScreen.Plan,
    BottomScreen.Meal,
    BottomScreen.Progress,
    BottomScreen.Profile
)