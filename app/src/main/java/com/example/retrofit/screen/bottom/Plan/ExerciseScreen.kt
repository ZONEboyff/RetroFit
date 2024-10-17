package com.example.retrofit.screen.bottom.Plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.data.Exercise
import com.example.retrofit.data.getCardioExercises
import com.example.retrofit.data.getStrengthExercises
import com.example.retrofit.ui.theme.contrastColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseScreen(
    exerciseType: Boolean,
    onExerciseSelected: (String, Exercise) -> Unit
) {
    val exercises = if (exerciseType) getCardioExercises() else getStrengthExercises()
    val headerTitle = if (exerciseType) "Cardio" else "Strength"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4A235A)) // Background color similar to the image
    ) {
        // Header
        TopAppBar(
            title = {
                Text(
                    text = headerTitle,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back navigation */ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color.White),

        )

        // Search Bar
        TextField(
            value = "",
            onValueChange = { /* Handle search */ },
            placeholder = { Text(text = "Search $headerTitle Workout", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.White)
            },
            colors = TextFieldDefaults.colors(
                contrastColor
            )
        )

        // Exercise List
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(exercises) { exercise ->
                ExerciseCard(exercise) { selectedExercise ->
                    onExerciseSelected(headerTitle, selectedExercise)
                }
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: Exercise, onClick: (Exercise) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(exercise) }
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Exercise Image
            Image(
                painter = painterResource(id = exercise.imageResId),
                contentDescription = exercise.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Exercise Info
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = exercise.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = exercise.description,
                    color = Color.White,
                    fontSize = 12.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Calories Burnt: ${exercise.caloriesBurned}",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}
