package com.example.jetpackcomposedemo.utils

open class EmailFieldState(
    email: String? = null,
) : TextFieldState(validator = ::isEmailValid, errorFor = ::inValidEmailError) {

    init {
        email?.let {
            text = it
        }
    }

}

fun isEmailValid(email: String?): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun inValidEmailError(email: String?): String {
    return "Invalid email $email"
}
