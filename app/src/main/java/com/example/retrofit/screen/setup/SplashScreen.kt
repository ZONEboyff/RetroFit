package com.example.retrofit.screen.setup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(onNavigate: (Boolean) -> Unit) {
    // Create an instance of FirebaseAuth
    val auth = remember { FirebaseAuth.getInstance() }

    LaunchedEffect(Unit) {
        // Delay to show the splash screen for a bit
        delay(300)

        // Check if user is signed in
        val isUserSignedIn = auth.currentUser != null
        // Navigate to the appropriate screen based on login status
        onNavigate(isUserSignedIn)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.whatsapp_image_2024_09_18_at_09_41_43_1b0a2859),
                    contentDescription = "Logo",
                    modifier = Modifier.size(250.dp)
                )
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
        SplashScreen{}
}