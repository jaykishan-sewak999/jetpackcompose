package com.example.jetpackcomposedemo.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "signIn") {
        composable("signIn") {
            SignIn(navController)
        }
        composable("signUp") {
           SignUp(navController)
        }
    }
}
