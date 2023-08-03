package com.example.jetpackcomposedemo.signup

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(SignUpClicked: (String, String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Sign Up",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.W700,
            ),
            modifier = Modifier.padding(15.dp)
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(15.dp)
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0XFFF5F5F5))
                    .padding(15.dp),
            ) {
                item {
                    Text(
                        text = "Name",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    OutlinedTextField(
                        value = "", onValueChange = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFEAEAEA),
                            focusedBorderColor = Color(0xFFEAEAEA),
                            unfocusedBorderColor = Color(0xFFEAEAEA),
                        ),
                        label = {
                            Text("Your Name")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Email",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    OutlinedTextField(
                        value = "", onValueChange = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFEAEAEA),
                            focusedBorderColor = Color(0xFFEAEAEA),
                            unfocusedBorderColor = Color(0xFFEAEAEA),
                        ),
                        label = {
                            Text("Your Email")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Password",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    OutlinedTextField(
                        value = "", onValueChange = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFEAEAEA),
                            focusedBorderColor = Color(0xFFEAEAEA),
                            unfocusedBorderColor = Color(0xFFEAEAEA),
                        ),
                        label = {
                            Text("Enter password")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Confirm Password",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    OutlinedTextField(
                        value = "", onValueChange = {},
                        shape = RoundedCornerShape(5.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color(0xFFEAEAEA),
                            focusedBorderColor = Color(0xFFEAEAEA),
                            unfocusedBorderColor = Color(0xFFEAEAEA),
                        ),
                        label = {
                            Text("Enter confirm password")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Sign up",)
                    }
                }
            }
            }
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(
                color = Color(0xFFF5F1F1),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp,),
            )
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp,),)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF5607F7)
            ),
            ) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.fb), contentDescription = "fb",
                    modifier = Modifier.size(25.dp))
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Sign up with Facebook")
                }

            }
        }

    }
}

@Preview
@Composable
fun PreviewSignUp() {
    SignUpScreen(SignUpClicked = { s, s2 -> })
}