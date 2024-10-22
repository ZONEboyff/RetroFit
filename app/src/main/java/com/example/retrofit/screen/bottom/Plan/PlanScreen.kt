package com.example.retrofit.screen.bottom.Plan

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.retrofit.R
import com.example.retrofit.data.Exercise
import com.example.retrofit.screen.Screen
import com.example.retrofit.ui.theme.backGroundColor
import com.example.retrofit.ui.theme.contrastColor
import com.example.retrofit.viewmodel.PlanViewModel


@Composable
fun PlanScreen(
    planViewModel: PlanViewModel,
    onAddClicked: () -> Unit
) {
    var selectedDay by remember { mutableStateOf("Monday") }

    val exercisesByDay = planViewModel.exercisesByDay.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backGroundColor)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Workout Plan",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp, top = 24.dp)
        )

        val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        Scaffold(
            modifier = Modifier.background(contrastColor),
            topBar = {
                NavigationBar(
                    containerColor = contrastColor,
                ) {
                    daysOfWeek.forEach { item ->
                        val isSelected = when (item) {
                            "Mon" -> selectedDay == "Monday"
                            "Tue" -> selectedDay == "Tuesday"
                            "Wed" -> selectedDay == "Wednesday"
                            "Thu" -> selectedDay == "Thursday"
                            "Fri" -> selectedDay == "Friday"
                            "Sat" -> selectedDay == "Saturday"
                            "Sun" -> selectedDay == "Sunday"
                            else -> false
                        }

                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                selectedDay = when (item) {
                                    "Mon" -> "Monday"
                                    "Tue" -> "Tuesday"
                                    "Wed" -> "Wednesday"
                                    "Thu" -> "Thursday"
                                    "Fri" -> "Friday"
                                    "Sat" -> "Saturday"
                                    "Sun" -> "Sunday"
                                    else -> selectedDay
                                }
                            },
                            icon = {
                                Text(
                                    text = item,
                                    color = if (isSelected) Color.White else Color.Black,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(padding)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = selectedDay,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    FloatingActionButton(
                        onClick = {
                            onAddClicked()
                        },
                        modifier = Modifier.padding(top = 16.dp),
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add Exercise")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                val exercises = exercisesByDay[selectedDay] ?: emptyList()

                LazyColumn(modifier = Modifier.weight(1f).padding(8.dp)) {
                    items(exercises) { exercise ->
                        ExerciseItem(exercise, onDelete = {
                            planViewModel.removeExerciseFromDay(selectedDay, exercise)
                        })
                    }
                }
            }
        }
    }
}



@Composable
fun ExerciseItem(exercise: Exercise, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(backGroundColor, RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = exercise.name, fontWeight = FontWeight.Bold)
            Text(text = exercise.duration, fontSize = 12.sp)
            Text(text = exercise.caloriesBurned, fontSize = 12.sp)
            IconButton(onClick = onDelete) {
                Icon(
                    painter = painterResource(id = R.drawable._11863_minus_round_icon_1_),
                    contentDescription = "Delete Exercise",
                )
            }
        }

        IconButton(onClick = onDelete) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = "Complete Exercises",
            )
        }
    }
}



