package com.example.jetpackcomposedemo.signin

import com.example.jetpackcomposedemo.neteork.LoginResponse
import com.example.jetpackcomposedemo.neteork.RetrofitClientInstance

object UserRepository {

    val apiService = RetrofitClientInstance.apiService

    suspend fun doLogin(user: User): LoginResponse {
        return apiService.login(user)
    }
}