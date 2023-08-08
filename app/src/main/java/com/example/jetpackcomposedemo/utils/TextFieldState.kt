package com.example.jetpackcomposedemo.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class TextFieldState(
    val validator: (String) -> Boolean,
    val errorFor: () -> String
) {
    var text: String by mutableStateOf("")
    var displayError: Boolean by mutableStateOf(false)

    open val isValid : Boolean
        get() = validator(text)

    open fun showError() : String?{
        return if(!isValid && text.length > 2)
            errorFor()
        else
            null
    }

    fun showErrors() = !isValid && displayError

}