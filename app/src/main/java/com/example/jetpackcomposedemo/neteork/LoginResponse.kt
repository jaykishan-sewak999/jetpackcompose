package com.example.jetpackcomposedemo.neteork

import com.example.jetpackcomposedemo.signin.User

data class LoginResponse(val string: String){
    var isSuccess: Boolean? =null
    var message: String?= null
}
