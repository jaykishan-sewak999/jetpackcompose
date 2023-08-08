package com.example.jetpackcomposedemo.utils

class PasswordFieldState: TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError)

class ConfirmPasswordState(private val passwordFieldState: PasswordFieldState) : TextFieldState(validator = ::isPasswordValid, errorFor = ::passwordValidationError){

    override val isValid: Boolean
        get() = validateConfirmPassword(passwordFieldState.text,text)

    override fun showError(): String? {
        return if (showErrors()){
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
private fun validateConfirmPassword(confirmPassword: String, password: String): Boolean {
    return (isPasswordValid(confirmPassword) && confirmPassword == password)
}

private fun inValidConfirmPassword(): String{
    return "Password and confirm password are not matching"
}