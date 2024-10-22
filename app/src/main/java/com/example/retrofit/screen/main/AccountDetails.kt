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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.retrofit.R

@Composable
fun AccountDetails(){
    var notificationsChecked by remember { mutableStateOf(false) }
    var isEditing by remember { mutableStateOf(false) }
    var isPasswordShown by remember { mutableStateOf(false) }

    if(!isEditing){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF632E5A))
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier=Modifier.padding(16.dp).fillMaxWidth()
            ) {
                Text(
                    text="Account",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(0.8f))
                //profile picture
                Box(
                    modifier= Modifier
                        .clip(shape = CircleShape)
                        .size(117.dp, 117.dp)
                        .background(color = Color.White)
                ) {
                    val profileIcon2 = painterResource(id = R.drawable.profile_icon2)
                    Icon(
                        painter = profileIcon2,
                        contentDescription = "Profile icon",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                IconButton(
                    modifier = Modifier.offset(x=-30.dp,y=70.dp),
                    onClick = {}
                ) {
                    Image(
                        painterResource(R.drawable.edit_pfp),
                        contentDescription = null,
                        modifier=Modifier.size(36.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            AccountDetailItem(
                image= painterResource(R.drawable.profile_icon1),
                text1 = "Name",
                text2 = "Jeff Powell"
            )
            AccountDetailItem(
                image = painterResource(R.drawable.email_icon),
                text1 = "Email",
                text2 = "jeffpowell123@example.in"
            )
            Row(
                modifier=Modifier.padding(8.dp).fillMaxWidth()
            ) {
                AccountDetailItem(
                    image = painterResource(R.drawable.password_icon),
                    text1 = "Password",
                    text2 = if(isPasswordShown) "abc#123" else "*********"
                )
                Spacer(modifier = Modifier.width(150.dp))
                IconButton(onClick = {isPasswordShown=!isPasswordShown}) {
                    Image(
                        modifier = Modifier.padding(top=4.dp),
                        painter =
                        if(isPasswordShown)
                            painterResource(R.drawable.password_shown)
                        else
                            painterResource(R.drawable.password_not_shown),
                        contentDescription = "Password Visibility"
                    )
                }
            }

            Row {
                AccountDetailItem(
                    image = painterResource(R.drawable.notification_icon),
                    text1 = "Notifications",
                    text2 = ""
                )
                Spacer(modifier=Modifier.width(140.dp))
                Switch(
                    modifier = Modifier.padding(8.dp),
                    checked = notificationsChecked,
                    onCheckedChange = {
                        notificationsChecked = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                        uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                        uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                    )
                )
            }
            AccountDetailItem(
                image = painterResource(R.drawable.bmi),
                text1 = "19.72",
                text2 = ""
            )
            AccountDetailItem(
                image = painterResource(R.drawable.calender_icon),
                text1 = "DOB",
                text2 = "12-09-2003"
            )
            Button(
                onClick = {}
            ) {
                Text(
                    text="Edit profile",
                    modifier=Modifier.clickable(onClick = {isEditing=true})
                )
            }
        }
    }
    else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF632E5A))
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier=Modifier.padding(16.dp).fillMaxWidth()
            ) {
                Text(
                    text="Account",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(0.8f))
                //profile picture
                Box(
                    modifier= Modifier
                        .clip(shape = CircleShape)
                        .size(117.dp, 117.dp)
                        .background(color = Color.White)
                ) {
                    val profileIcon2 = painterResource(id = R.drawable.profile_icon2)
                    Icon(
                        painter = profileIcon2,
                        contentDescription = "Profile icon",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                IconButton(
                    modifier = Modifier.offset(x=-30.dp,y=70.dp),
                    onClick = {}
                ) {
                    Image(
                        painterResource(R.drawable.edit_pfp),
                        contentDescription = null,
                        modifier=Modifier.size(36.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            AccountDetailItem(
                image= painterResource(R.drawable.profile_icon1),
                text1 = "Name",
                text2 = "Jeff Powell"
            )
            AccountDetailItem(
                image = painterResource(R.drawable.email_icon),
                text1 = "Email",
                text2 = "jeffpowell123@example.in"
            )
            Row(
                modifier=Modifier.padding(8.dp).fillMaxWidth()
            ) {
                AccountDetailItem(
                    image = painterResource(R.drawable.password_icon),
                    text1 = "Password",
                    text2 = if(isPasswordShown) "abc#123" else "*********"
                )
                Spacer(modifier = Modifier.width(150.dp))
                IconButton(onClick = {isPasswordShown=!isPasswordShown}) {
                    Image(
                        modifier = Modifier.padding(top=4.dp),
                        painter =
                        if(isPasswordShown)
                            painterResource(R.drawable.password_shown)
                        else
                            painterResource(R.drawable.password_not_shown),
                        contentDescription = "Password Visibility"
                    )
                }
            }

            Row {
                AccountDetailItem(
                    image = painterResource(R.drawable.notification_icon),
                    text1 = "Notifications",
                    text2 = ""
                )
                Spacer(modifier=Modifier.width(140.dp))
                Switch(
                    modifier = Modifier.padding(8.dp),
                    checked = notificationsChecked,
                    onCheckedChange = {
                        notificationsChecked = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                        uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                        uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                    )
                )
            }
            AccountDetailItem(
                image = painterResource(R.drawable.bmi),
                text1 = "19.72",
                text2 = ""
            )
            AccountDetailItem(
                image = painterResource(R.drawable.calender_icon),
                text1 = "DOB",
                text2 = "12-09-2003"
            )
            Button(
                onClick = {}
            ) {
                Text(
                    text="Done",
                    modifier = Modifier.clickable(onClick = {isEditing=false})
                )
            }
        }
    }
    
}

@Composable
fun AccountDetailItem(
    image: Painter,
    text1:String,
    text2:String
){
    Row(
        modifier=Modifier.padding(8.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier=Modifier
                .size(32.dp)
                .align(Alignment.CenterVertically)
        )
        Column(
            modifier=Modifier.padding(16.dp)
        ) {
            if(text2==""){
                Spacer(modifier = Modifier.height(4.dp))
            }
            Text(text=text1, color = Color.White)
            if(text2!=""){
                Spacer(modifier = Modifier.height(4.dp))
                Text(text=text2, color = Color.White)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountDetailsPreview(){
    AccountDetails()
}