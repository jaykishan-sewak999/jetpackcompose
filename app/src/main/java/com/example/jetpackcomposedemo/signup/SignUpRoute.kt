package com.example.jetpackcomposedemo.signup

import androidx.compose.runtime.Composable

@Composable
fun SignUpRoute(SignUpClicked : (email: String, pass: String) -> Unit){
    SignUpScreen(SignUpClicked = SignUpClicked)
}