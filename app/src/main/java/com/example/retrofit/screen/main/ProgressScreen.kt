package com.example.retrofit.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R

@Composable
fun ProgressScreen(onStepScreen:()->Unit){
    Column(
        modifier=Modifier
            .background(Color(0xFF632E5A))
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Progress",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color=Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = Color.White, thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text="Activity data",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            onClick = {onStepScreen()}) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text="Steps",
                    fontSize=30.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painterResource(R.drawable.steps_icon),
                    contentDescription = "shoes",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.weight(0.8f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier=Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            onClick = {}) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text="Distance",
                    fontSize=30.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painterResource(R.drawable.distance_icon),
                    contentDescription = "distance",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.weight(0.8f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            onClick = {}) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text="Calories",
                    fontSize=30.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painterResource(R.drawable.calorie_icon),
                    contentDescription = "calories",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.weight(0.8f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(modifier=Modifier.height(16.dp))
        HorizontalDivider(color = Color.White, thickness=1.dp)
        Spacer(modifier=Modifier.height(16.dp))
        Text(
            text="Health data",
            fontSize=20.sp,
            color=Color.White,
            modifier=Modifier.align(Alignment.Start)
        )
        Spacer(modifier=Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth().padding(4.dp),
            onClick = {}) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text="Weight",
                    fontSize=30.sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painterResource(R.drawable.weight_logo),
                    contentDescription = "weight",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.weight(0.8f))
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null
                    )
                }
            }
        }

    }
}

