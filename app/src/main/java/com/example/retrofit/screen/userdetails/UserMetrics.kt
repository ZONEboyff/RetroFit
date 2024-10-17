package com.example.retrofit.screen.userdetails

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R
import com.example.retrofit.viewmodel.AuthViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserMetricsScreen(onNextClicked: (String,String) -> Unit, onBackClicked: () -> Unit) {
    val heightState = remember { mutableStateOf("169") }
    val weightState = remember { mutableStateOf("69") }
    var isCmSelected by remember { mutableStateOf(true) }
    var isKgSelected by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Back Arrow and Step
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onBackClicked() },
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF2C0926)),
                modifier = Modifier.width(80.dp)
            ){
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                )
            }

            Text(
                text = "STEP 2",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .border(1.dp, Color.Magenta, shape = RoundedCornerShape(20.dp))
                    .padding(8.dp)
            )
        }
        Text("Enter Your Height And Weight",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF930093), )
        // Height
        Column {
            Text(text = "Height", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = heightState.value,
                    onValueChange = { heightState.value = it },
                    modifier = Modifier.width(100.dp),
                    textStyle = TextStyle(fontSize = 24.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                UnitToggleButton(
                    selected = isCmSelected,
                    text1 = "Cm",
                    text2 = "Inch",
                    onToggle = { isCmSelected = it }
                )
            }
        }

        // Weight
        Column {
            Text(text = "Weight", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = weightState.value,
                    onValueChange = { weightState.value = it },
                    modifier = Modifier.width(100.dp),
                    textStyle = TextStyle(fontSize = 24.sp),
                    shape = RoundedCornerShape(10.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                UnitToggleButton(
                    selected = isKgSelected,
                    text1 = "Kg",
                    text2 = "lbs",
                    onToggle = { isKgSelected = it }
                )
            }
        }

        // Image (Replace with your actual image)
        Image(
            painter = painterResource(id = R.drawable.treadmill_image), // Add actual image here
            contentDescription = "Woman on treadmill",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        // Next Button
        Button(
            onClick = { onNextClicked(heightState.value,weightState.value) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color(0xFF6A1B9A), Color(0xFFD500F9))
                    ),
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(text = "Next", color = Color.White)
        }
    }
}

@Composable
fun UnitToggleButton(
    selected: Boolean,
    text1: String,
    text2: String,
    onToggle: (Boolean) -> Unit
) {
    Row {
        Button(
            onClick = { onToggle(true) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selected) Color(0xFF930093) else Color.LightGray
            ),
            modifier = Modifier
                .height(50.dp),

        ) {
            Text(text = text1, color = Color.White)
        }
        Button(
            onClick = { onToggle(false) },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!selected) Color(0xFF930093) else Color.LightGray
            ),
            modifier = Modifier
                .height(50.dp)
        ) {
            Text(text = text2, color = Color.White)
        }
    }
}



