package com.example.retrofit.screen.setup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R
import com.example.retrofit.ui.theme.gradient

@Composable
fun LandingScreen(onStartClicked:()->Unit){
    var visible by remember{ mutableStateOf(false) }
    LaunchedEffect(Unit) {
        visible = true
    }
        Column{
            Box(modifier = Modifier.background(gradient).fillMaxSize()){
                Row(modifier = Modifier.padding(start = 50.dp), horizontalArrangement = Arrangement.Center){
                    AnimatedVisibility(
                        visible = visible,
                        enter = slideInHorizontally(
                            initialOffsetX = { it },
                            animationSpec = tween(800)
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.landingimage2),
                            contentDescription = "Image 2",
                            modifier = Modifier.size(2500.dp)
                        )
                    }
                }

                Row(modifier = Modifier.padding(end = 50.dp), horizontalArrangement = Arrangement.SpaceBetween){
                    AnimatedVisibility(
                        visible = visible,
                        enter = slideInHorizontally(
                            initialOffsetX = { -it },
                            animationSpec = tween(800)
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.landingimage1),
                            contentDescription = "Image 1",
                            modifier = Modifier.size(500.dp)
                        )
                    }
                }
                Text("RetroFit", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.align(Alignment.BottomStart).padding(start = 50.dp, bottom = 140.dp))
                Text("Your Personalized Trainer", color = Color.White, fontSize = 20.sp, modifier = Modifier.align(Alignment.BottomStart).padding(start = 50.dp, bottom = 110.dp))
                Button(onClick = { onStartClicked() },
                    border = BorderStroke(1.dp, Color.White),
                    shape = RectangleShape,
                    colors= ButtonDefaults.buttonColors(Color.Transparent),
                    modifier = Modifier.padding(30.dp).fillMaxWidth().align(Alignment.BottomCenter)) {
                    Text(text = "Get Started", color = Color.White, fontSize = 20.sp)
                }

            }
        }


}
@Preview(showBackground = true)
@Composable
fun LandingScreenPreview(){
    LandingScreen{}
}