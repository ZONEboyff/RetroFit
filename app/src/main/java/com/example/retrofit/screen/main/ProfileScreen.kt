package com.example.retrofit.screen.main

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R

@Composable
fun ProfileScreen() {
    val height = 169
    val weight = 55
    val username="Jeff Powell"
    val age = 26
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF632E5A)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier=Modifier.height(32.dp))
        Text(
            text = "PROFILE",
            fontSize = 23.sp,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.size(16.dp))
        //profile picture
        Box(
            modifier= Modifier
                .clip(shape = CircleShape)
                .size(117.dp, 117.dp)
                .background(color = Color.White)
        ) {
            val profile_icon = painterResource(id = R.drawable.profile_icon2)
            Icon(
                painter = profile_icon,
                contentDescription = "Profile icon",
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text=username,
            fontSize = 23.sp,
            color = Color.White
        )
        Spacer(modifier=Modifier.size(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(width = 98.dp, height = 98.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(width = 98.dp, height = 98.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center
                ) {
                    Icon(
                        painterResource(R.drawable.weight_icon),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "$weight kg",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(width = 98.dp, height = 98.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(width = 98.dp, height = 98.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center
                ) {
                    Icon(
                        painterResource(R.drawable.height_icon),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "$height cm",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(width = 98.dp, height = 98.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(width = 98.dp, height = 98.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center
                ) {
                    Icon(
                        painterResource(R.drawable.birthday_icon),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "$age years",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

        }
        Spacer(modifier=Modifier.size(16.dp))
        Card(
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                modifier=Modifier.padding(16.dp)
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Account", fontWeight = FontWeight.Bold)
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Progress", fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        modifier=Modifier.size(24.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Weekly planner", fontWeight = FontWeight.Bold)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        modifier=Modifier.size(24.dp)
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text="Log out",
                        fontWeight = FontWeight.Bold,
                        modifier=Modifier
                            .clickable(onClick = {/*implement logout logic*/})
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}