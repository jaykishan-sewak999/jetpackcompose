package com.example.jetpackcomposedemo.neteork

import com.example.jetpackcomposedemo.signin.User

data class LoginResponse(val user: User){
    var isSuccess: Boolean? =null
    var message: String?= null
}
