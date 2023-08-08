package com.example.jetpackcomposedemo.utils

open class EmailFieldState: TextFieldState(validator = ::isEmailValid, errorFor = ::inValidEmailError)

fun isEmailValid(email: String?): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun inValidEmailError(): String {
    return "Invalid email"
}
