package com.example.jetpackcomposedemo.signup

import androidx.compose.runtime.Composable

@Composable
fun SignUpRoute(SignUpClicked: (String, String) -> Unit){
    SignUpScreen(SignUpClicked = SignUpClicked)
}