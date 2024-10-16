package com.example.retrofit.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R

@Composable
fun MealMainScreen(navigationToIngredient:(String)->Unit){
    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFF632E5A))
            .padding(16.dp),



        ){
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(){
                Text(
                    text = "MEAL PREPARATION",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    ),
                    modifier = Modifier
                        .border(2.dp, Color.White, shape = RoundedCornerShape(100))
                        .background(Color.White)
                        .padding(8.dp)

                )
                Icon(Icons.Default.Search, contentDescription =null, modifier = Modifier.height(42.dp).width(40.dp).background(Color.White))


            }

            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .size(width = 500.dp, height = 555.dp)  // Rectangle size
                    .background(Color(0xFF2C0926))
                    .clip(RoundedCornerShape(20.dp))

            ){
                Column (modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)  ){

                    Image(painterResource(R.drawable.breakfastgrp), contentDescription =null,modifier=Modifier.height(130.dp).width(400.dp).clickable { navigationToIngredient("ingredient") })
                    Image(painterResource(R.drawable.lunch), contentDescription =null,modifier=Modifier.height(130.dp).width(400.dp))
                    Image(painterResource(R.drawable.snack), contentDescription =null,modifier=Modifier.height(130.dp).width(400.dp))
                    Image(painterResource(R.drawable.dinner), contentDescription =null,modifier=Modifier.height(130.dp).width(400.dp))

                }


            }





        }

    }
}
@Preview(showBackground = true)
@Composable
fun MealMainScreenPreview(){
    MealMainScreen({})
}