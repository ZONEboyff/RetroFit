package com.example.retrofit.screen.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R
import com.example.retrofit.ui.theme.Purple40
import com.example.retrofit.ui.theme.backGroundColor
import com.example.retrofit.ui.theme.contrastColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it).background(backGroundColor)
        ) {
            HeaderSection()
            GoalsSection()
            SuggestedWorkoutsSection()
            WorkoutImageSection()
        }
    }
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Hi Jeff!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Let's Check out your activity",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun GoalsSection() {
    Card(colors = CardDefaults.cardColors(containerColor = contrastColor)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp).background(backGroundColor),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = { 0.54f },
                    modifier = Modifier.size(80.dp),
                    color = Purple40,
                    strokeWidth = 6.dp,
                )
                Text(
                    text = "54%",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Calories Burnt",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "1080 / 2000 cal",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Steps",
                    fontSize = 16.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "735 / 1000",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun SuggestedWorkoutsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Suggested Workouts",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        WorkoutItem("Lateral Raises", "X10", "3 SETS")
        WorkoutItem("Push Ups", "X20", "3 SETS")
        WorkoutItem("Jogging", "3 KM", "1 SET")
    }
}

@Composable
fun WorkoutItem(name: String, reps: String, sets: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .weight(0.5f)
                .padding(8.dp)
        ) {
            Text(
                text = reps,
                color = Color.Magenta,
                fontSize = 14.sp
            )
        }
        Box(
            modifier = Modifier
                .weight(0.5f)
                .padding(8.dp)
        ) {
            Text(
                text = sets,
                color = Color.DarkGray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun WorkoutImageSection() {
    Image(
        painter = painterResource(id = R.drawable.lifting_image), // Replace with your image resource
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentScale = ContentScale.Crop
    )
}
