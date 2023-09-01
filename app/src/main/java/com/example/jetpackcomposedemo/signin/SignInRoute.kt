package com.example.jetpackcomposedemo.signin

import androidx.compose.runtime.Composable

@Composable
fun SignInRoute(OnSignInClicked :(String, String) -> Unit, OnSkipClicked : () -> Unit){
    SignInScreen(OnSignInClicked = OnSignInClicked, OnSkipClicked = OnSkipClicked)
}