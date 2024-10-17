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
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
fun FitnessStatusScreen(onDoneClicked: (Float) -> Unit, onBackClicked: () -> Unit) {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Row: Back Button and Step Text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onBackClicked() },
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color(0xFF2C0926)),
                modifier = Modifier.width(80.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Text(
                text = "STEP 4",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Magenta,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .border(1.dp, Color.Magenta, shape = RoundedCornerShape(20.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title: Current Fitness Status
        Text(
            text = "Current Fitness Status",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9C27B0)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fitness Status Image (Replace with your actual image resource)
        Image(
            painter = painterResource(id = R.drawable.fitness_image), // Replace with actual resource ID
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Instruction Text
        Text(
            text = "Pick the option that matches you best.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Hand Icon and Slider Instruction
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.hand_icon), // Replace with actual hand icon resource ID
                contentDescription = "Slide to choose",
                tint = Color.Black,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Slide to choose",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fitness Status Slider
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 0f..1f,
                steps = 9, // Number of steps in between Poor and Excellent
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF42A5F5),
                    activeTrackColor = Color.Blue
                ),
                modifier = Modifier.fillMaxWidth()
            )

            // Slider Labels (Poor, Moderate, Excellent)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Poor", color = Color.Black)
                Text(text = "Moderate", color = Color.Black)
                Text(text = "Excellent", color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Done Button with Gradient Background
        Button(
            onClick = { onDoneClicked(sliderPosition) },
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
            Text(text = "Done", color = Color.White)
        }
    }
}

