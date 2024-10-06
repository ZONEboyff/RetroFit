package com.example.retrofit.screen


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
    object BottomScreen{
        object HomeScreen:Screen("home_screen")
    }

}