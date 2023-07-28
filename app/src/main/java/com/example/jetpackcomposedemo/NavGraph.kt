package com.example.jetpackcomposedemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemo.Destinations.SIGN_IN
import com.example.jetpackcomposedemo.Destinations.SIGN_UP
import com.example.jetpackcomposedemo.Destinations.WELCOME_ROUTE
import com.example.jetpackcomposedemo.ui.theme.SignIn
import com.example.jetpackcomposedemo.ui.theme.SignUp
import com.example.jetpackcomposedemo.welcome.WelcomeRoute

object Destinations {
    const val SIGN_IN = "signin"
    const val SIGN_UP = "signup"
    const val WELCOME_ROUTE = "welcome"
}
@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = SIGN_IN) {
        composable(WELCOME_ROUTE) {
            WelcomeRoute(OnSignInClicked = {
                navController.navigate(SIGN_IN)
            },
            OnSignUpClicked = {
                navController.navigate(SIGN_UP)
            })
        }
        composable(SIGN_IN) {
        SignIn()
        }

    }
}
