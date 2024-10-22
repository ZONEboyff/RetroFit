package com.example.retrofit.screen.bottom.Plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.retrofit.R
import com.example.retrofit.ui.theme.backGroundColor
import com.example.retrofit.viewmodel.PlanViewModel

@Composable
fun TypeSelectionScreen(onTypeSelected: (Boolean?) -> Unit,onBackClicked:()->Unit) {
    val backgroundColor = Color(0xFF5B2C68)
    val buttonColor = Color(0xFFD3D3D3)
    val buttonTextColor = Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // Back button
        Button(
            onClick = { onBackClicked() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2C0926)),
            modifier = Modifier.width(130.dp).padding(20.dp)
        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card for CARDIO
        ExerciseCard(
            title = "CARDIO",
            imageResId = R.drawable.cardio, // Replace with your image
            onClick = { onTypeSelected(true) } // Call with true for cardio
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card for STRENGTH
        ExerciseCard(
            title = "STRENGTH",
            imageResId = R.drawable.strength, // Replace with your image
            onClick = { onTypeSelected(false) } // Call with false for strength
        )
    }
}

@Composable
fun ExerciseCard(title: String, imageResId: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() }, // Make the card clickable
        colors = CardDefaults.cardColors(backGroundColor),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.elevatedCardElevation(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Exercise title
            Text(
                text = title,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(1f)
            )

            // Exercise image
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "$title image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
