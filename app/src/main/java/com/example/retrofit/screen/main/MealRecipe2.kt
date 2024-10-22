package com.example.retrofit.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R

@Composable
fun RecipeProcedure(navigationToIngredient:(String)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF632E5A))
    ) {
        Spacer(modifier = Modifier.padding(8.dp))

        // Header section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title Box
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 200.dp, height = 50.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(60.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Today's Meals",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            // Image below the title
            Image(
                painterResource(R.drawable.meal),
                contentDescription = null,
                modifier = Modifier
                    .height(240.dp)
                    .width(400.dp)
            )

            // Yellow Procedure Box
            Box(
                modifier = Modifier
                    .height(330.dp)
                    .width(330.dp)
                    .background(Color(0xFFE5FF9B))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                    //.padding(16.dp)
                ) {
                    // Header for Procedure Box
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(width = 1.dp, color = Color.Black)
                            .padding(8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.size(width = 45.dp, height = 28.dp)
                                    .clickable { navigationToIngredient("ingredientScreen") }
                            )
                            Spacer(modifier = Modifier.width(55.dp))
                            Text(
                                text = "PROCEDURE",
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.width(55.dp))
                            Icon(
                                painterResource(R.drawable.procedure_side),
                                contentDescription = null,
                                modifier = Modifier.size(width = 45.dp, height = 28.dp)
                            )
                        }
                    }

                    // Scrollable content inside the Procedure box
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)  // Takes up all remaining space
                            .padding(8.dp)
                    ) {
                        item{
                            TextWithIcon("Prepare the Ingredients: Cook rice, rinse beans, and prepare your protein and fresh vegetables.")
                            TextWithIcon("Warm the Tortilla: Heat the tortilla on a skillet for about 30 seconds on each side until pliable.")
                            TextWithIcon("Assemble the Burrito: Layer rice, beans, protein, cheese, and fresh vegetables in the center of the tortilla.")
                            TextWithIcon("Roll the Burrito: Fold in the sides of the tortilla and roll it tightly from the bottom upwards.")
                            TextWithIcon("Serve: Place the burrito seam-side down on a plate, optionally slice it in half, and serve.")
                            TextWithIcon("Enjoy: Serve with extra salsa, guacamole, or sour cream on the side.")

                        }
                    }

                    // White box at the bottom (Non-scrollable)
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .background(Color.White)
                            .padding(6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Tip: Make a large batch in advance and keep in the freezer for a quick meal.",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,

                                )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RecipeProcedurePreview() {
    RecipeProcedure({})
}
