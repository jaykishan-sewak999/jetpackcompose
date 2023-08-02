package com.example.jetpackcomposedemo.utils

class PasswordFieldState: TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError)

fun isPasswordValid(password: String): Boolean{
    return password.length > 6
}

private fun passwordValidationError(password: String): String {
    return "Invalid password"
}