package com.example.retrofit.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun MealRecipe(navigationToProcedure:(String)->Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF632E5A))

    ) {
        Spacer(modifier = Modifier.padding(8.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 200.dp, height = 50.dp)  // Rectangle size
                    .background(Color.White),
                //.clip(RoundedCornerShape(60.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Todays Meals",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Image(
                painterResource(R.drawable.meal),
                contentDescription = null,
                modifier = Modifier.height(240.dp).width(400.dp)
            )

            Box(
                modifier = Modifier
                    //.padding(8.dp)
                    .size(width = 330.dp, height = 330.dp)  // Rectangle size
                    .background(Color.White)
                //.clip(RoundedCornerShape(30.dp))
            ) {
                LazyColumn {
                    item {
                        Text(
                            "   CALORIES: XXX  |  PROTEINS:29g  | CARBOHYDRATES:72g",
                            maxLines = 1,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            ),

                            )

                        Spacer(modifier = Modifier.height(1.dp))
                        Box(
                            Modifier.background(Color(0xFFFFEF9B)).size(width = 350.dp, height = 30.dp),
                            contentAlignment = Alignment.Center

                        ){
                            Text("BURRITO  INGREDIENTS",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                ))
                        }


                        Box(
                            modifier = Modifier
                                .background(Color(0xFFFFEF9B))
                                .size(width = 350.dp, height = 180.dp)
                        ) {
                            Column (Modifier.verticalScroll(rememberScrollState())

                            ){

                                TextWithIcon("Tortilla (large flour tortilla)")
                                TextWithIcon("Rice (seasoned or plain)")
                                TextWithIcon("Beans (black beans, pinto beans, or refried beans)")
                                TextWithIcon("Protein (chicken, beef, pork, tofu, or grilled vegetables for a vegetarian option)")
                                TextWithIcon("Cheese (shredded cheddar, Monterey Jack, or a cheese blend)")
                                TextWithIcon("Sour Cream")
                                TextWithIcon("Guacamole")
                                TextWithIcon("Salsa (mild, medium, or spicy, depending on preference)")
                                TextWithIcon("Lettuce (shredded)")
                                TextWithIcon("Tomatoes (diced)")


                            }
                        }

                        Box(
                            modifier = Modifier
                                .background(Color(0xFFD9D9D9))
                                .size(width = 350.dp, height = 40.dp)
                                .clickable { navigationToProcedure("procedure") },
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Click here for procedure ->", color = Color.Blue, fontSize = 20.sp)
                        }

                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(60.dp)
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(40.dp)
                                    .padding(2.dp), // Optional padding around the button
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE7AF44)), // Use containerColor for background
                                shape = RoundedCornerShape(8.dp) // Optional: rounded corners
                            ) {

                                Text(
                                    "SWAP",
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp
                                    )
                                )
                            }

                            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                                Icon(
                                    painterResource(R.drawable.like),
                                    contentDescription = null,
                                    Modifier.size(height = 25.dp, width = 25.dp)
                                )
                                Icon(
                                    painterResource(R.drawable.dislike),
                                    contentDescription = null,
                                    Modifier.size(height = 25.dp, width = 25.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun MealRecipePreview() {
    MealRecipe({})
}

@Composable
fun TextWithIcon(name: String){
    Row {
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            "$name",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            modifier = Modifier.padding(5.dp))

    }

}

