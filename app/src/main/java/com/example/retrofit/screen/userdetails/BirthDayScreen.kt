import android.app.DatePickerDialog
import android.widget.DatePicker
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.R
import java.util.Calendar

@Composable
fun DateOfBirthScreen(onNextClicked: (String) -> Unit, onBackClicked: () -> Unit) {
    // State for holding selected date
    var selectedDate by remember { mutableStateOf("") }

    // Calendar instance for DatePicker
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // DatePickerDialog
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day
    )

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
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }

            Text(
                text = "STEP 3",
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

        // Title: Date of Birth
        Text(
            text = "Enter Your Date Of Birth",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF9C27B0)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Birthday Image
        Image(
            painter = painterResource(id = R.drawable.birthday_icon), // Replace with actual resource ID
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Date Picker Button
        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier
                .border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = selectedDate.ifEmpty { "Select Date" },
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Next Button with Gradient Background
        Button(
            onClick = { onNextClicked(selectedDate) },
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
@Preview(showBackground = true)
@Composable
fun DateOfBirthScreenPreview() {
    DateOfBirthScreen({}, {})
}
