package com.example.jetpackcomposedemo.welcome

import androidx.compose.runtime.Composable

@Composable
fun WelcomeRoute(
    OnSignInClicked :() -> Unit,
    OnSignUpClicked : () -> Unit
){
    WelcomeScreen(OnSignInClick = OnSignInClicked, OnSignUpClick = OnSignUpClicked)
}