package com.example.retrofit.screen.setup
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R
import com.example.retrofit.data.AuthResult
import com.example.retrofit.viewmodel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onSignUp: () -> Unit,
    onForgotPassword: () -> Unit,
    onLogIn: () -> Unit,
    authViewModel: AuthViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = androidx.compose.ui.platform.LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            account?.idToken?.let { idToken ->
                // Call ViewModel to sign in with the token
                coroutineScope.launch {
                    isLoading = true
                    authViewModel.signInWithGoogle(idToken) { authResult ->
                        if (authResult is AuthResult.Success) {
                            onLogIn() // Handle login success
                            isLoading= false
                        } else {
                            Toast.makeText(context, "Google Sign-In Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        } catch (e: ApiException) {
            Toast.makeText(context, "Google Sign-In Failed", Toast.LENGTH_SHORT).show()
        }
    }

    // Trigger Google Sign-In when the user clicks the Google icon
    fun triggerGoogleSignIn() {
        val googleSignInClient = GoogleSignIn.getClient(context, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build())

        launcher.launch(googleSignInClient.signInIntent)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo at the top
        val logo: Painter = painterResource(id = R.drawable.app_logo) // Replace with actual logo resource
        Image(painter = logo, contentDescription = "RetroFit Logo", modifier = Modifier.size(100.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // App Name
        Text(
            text = "RetroFit",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            color = Color(0xFFB12EB4) // Purple
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Email input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(painterResource(id = R.drawable.email), contentDescription = "Email Icon", modifier = Modifier.size(20.dp))
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password input
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(painterResource(id = R.drawable.password), contentDescription = "Password Icon", modifier = Modifier.size(20.dp))
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.baseline_visibility_24)
                else
                    painterResource(id = R.drawable.baseline_visibility_off_24)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Forgot Password Text
        ClickableText(
            text = AnnotatedString("Forgot Password?"),
            onClick = { onForgotPassword() },
            style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF9C27B0))
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Login Button
        Button(
            onClick = {
                isLoading = true
                authViewModel.login(email, password) { result ->
                    isLoading = false
                    message = when (result) {
                        is AuthResult.Success -> "Login Successful"
                        is AuthResult.Error -> "Error: ${result.message}"
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF9C27B0))
        ) {
            Text(text = "Log In", color = Color.White)
        }

        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                CircularProgressIndicator()
            }
        }

        LaunchedEffect(message) {
            if (message == "Login Successful") {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                onLogIn() // Call the onLogIn callback
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Alternative login options
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Log In using", color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painterResource(id = R.drawable.twitter_logo), contentDescription = "Twitter Logo", modifier = Modifier.size(48.dp)) // X logo
            Image(painterResource(id = R.drawable.google_logo), contentDescription = "Google Logo", modifier = Modifier.size(48.dp).clickable { triggerGoogleSignIn() }) // Google logo
            Image(painterResource(id = R.drawable.facebook_logo), contentDescription = "Facebook Logo", modifier = Modifier.size(48.dp)) // Facebook logo
        }

        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Need An Account?", color = Color.Gray)
            Spacer(modifier = Modifier.width(4.dp))
            ClickableText(
                text = AnnotatedString("Sign Up"),
                onClick = { onSignUp() },
                style = MaterialTheme.typography.bodyLarge.copy(color = Color(0xFF9C27B0))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RetrofitLoginScreenPreview() {
    LoginScreen(onForgotPassword = {}, onLogIn = {}, onSignUp = {}, authViewModel = AuthViewModel())
}
