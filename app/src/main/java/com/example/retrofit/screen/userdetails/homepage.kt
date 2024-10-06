package com.example.retrofit.screen.userdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.retrofit.R

@Composable
fun HomeScreen(){
    Image(painter = painterResource(id = R.drawable.android_large___11), contentDescription = null,
        modifier = Modifier.size(2500.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    HomeScreen()
}