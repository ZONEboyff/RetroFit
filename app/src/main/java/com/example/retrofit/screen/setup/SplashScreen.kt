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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(onTimeout: ()->Unit) {
     LaunchedEffect(Unit) {
         delay(300)
         onTimeout()
     }
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ){
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
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