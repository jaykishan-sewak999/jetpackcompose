package com.example.jetpackcomposedemo.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(SignUpClicked: (String, String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
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
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0XFFF5F5F5))
                    .padding(15.dp),
            ) {
                Text(
                    text = "Name",
                    style = TextStyle(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = "", onValueChange = {},
                    shape = RoundedCornerShape(5.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color(0xFFEAEAEA),
                        focusedBorderColor = Color(0xFFEAEAEA),
                        unfocusedBorderColor = Color(0xFFEAEAEA),
                    ),
                    label = {
                        Text("Your name")
                    },



                )

            }
        }

    }
}

@Preview
@Composable
fun PreviewSignUp() {
    SignUpScreen(SignUpClicked = { s, s2 -> })
}