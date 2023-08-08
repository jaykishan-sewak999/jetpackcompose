package com.example.jetpackcomposedemo.utils

class PasswordFieldState: TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError)

class ConfirmPasswordState(private val passwordFieldState: PasswordFieldState) : TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError){

    override val isValid
        get() = validateConfirmPassword(passwordFieldState.text,text)

    override fun showError(): String? {
        return if (text.length >2 ){
            inValidConfirmPassword()
        } else{
            null
        }
    }
}

fun isPasswordValid(password: String): Boolean{
    return password.length > 6
}

private fun passwordValidationError(): String {
    return "Invalid password"
}
private fun validateConfirmPassword(password: String, confirmPassword: String): Boolean {
    return (isPasswordValid(password) && confirmPassword == password)
}

private fun inValidConfirmPassword(): String{
    return "Password and confirm password are not matching"
}