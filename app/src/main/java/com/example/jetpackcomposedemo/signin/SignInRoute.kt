package com.example.jetpackcomposedemo.signin

import androidx.compose.runtime.Composable

@Composable
fun SignInRoute(OnSignInClicked :(email: String, password: String) -> Unit){
    SignInScreen(OnSignInClicked = {
        email, password ->  OnSignInClicked(email, password)
    })
}