package com.example.retrofit.screen.userdetails

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.R

@Composable
fun GenderScreen(onNextClicked: (String) -> Unit, onBackClicked: () -> Unit) {
    var selectedGender by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Top Row: Back Button and Step Text
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
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                )
            }

            Text(
                text = "STEP 1",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .border(1.dp, Color.Magenta, shape = RoundedCornerShape(20.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Fitness Details Title
        Text(
            text = "Fitness Details",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9C27B0)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Gender Selection Label
        Text(
            text = "Choose Your Gender",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color(0xFF9C27B0)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Gender Radio Buttons
        GenderSelectionRow(
            gender = "Male",
            selectedGender = selectedGender,
            onGenderSelected = { selectedGender = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        GenderSelectionRow(
            gender = "Female",
            selectedGender = selectedGender,
            onGenderSelected = { selectedGender = it }
        )

        Spacer(modifier = Modifier.weight(1f))

        // Next Button with Gradient Background
        Button(
            onClick = { onNextClicked(selectedGender.let { "" }) },
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
fun GenderSelectionRow(
    gender: String,
    selectedGender: String?,
    onGenderSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedGender == gender,
            onClick = { onGenderSelected(gender) },
            colors = RadioButtonDefaults.colors(selectedColor = Color.Black, unselectedColor = Color(0xFF9C27B0))
        )

        Spacer(modifier = Modifier.width(8.dp))

        if (gender == "Male") {
            Icon(
                painter = painterResource(id = R.drawable.baseline_male_24),
                contentDescription = null,
                tint = Color.Black
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.baseline_female_24),
                contentDescription = null,
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = gender,
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessDetailsScreenPreview() {
    GenderScreen({}, {})
}
