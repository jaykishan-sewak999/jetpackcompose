package com.example.jetpackcomposedemo.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.ui.theme.Purple40

@Composable
fun WelcomeScreen(
    OnSignInClick: () -> Unit,
    OnSignUpClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_placeholder),
                contentDescription = "user place holder",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Welcome",
                style = TextStyle(
                    fontSize = 28.sp,
                    color = Purple40,
                    fontWeight = FontWeight.W700
                )
            )
            Text(
                "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable",
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = { OnSignInClick() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2EDC83),),
                    border = BorderStroke(1.dp, color = Color.Black)
                ) {
                    Text(text = "Sign In")
                }
                OutlinedButton(
                    onClick = { OnSignUpClick() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2EDC83)),
                    border = BorderStroke(width = 1.dp, color = Color.Black)
                ) {
                    Text(text = "Sign Up")
                }
            }
        }
    }
}
@Preview
@Composable
fun PreViewWelcome(){
    WelcomeScreen(OnSignInClick = { /*TODO*/ }) {
        
    }
}