package com.example.jetpackcomposedemo.signin

import androidx.compose.runtime.Composable

@Composable
fun SignInRoute(OnSignInClicked :(String, String) -> Unit){
    SignInScreen(OnSignInClicked = {
        email, password ->  OnSignInClicked(email, password)
    })
}