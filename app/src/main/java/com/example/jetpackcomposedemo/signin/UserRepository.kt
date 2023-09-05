package com.example.jetpackcomposedemo.signin

import com.example.jetpackcomposedemo.dashboard.UsersListResponse
import com.example.jetpackcomposedemo.neteork.LoginResponse
import com.example.jetpackcomposedemo.neteork.RetrofitClientInstance
import com.example.jetpackcomposedemo.neteork.RetrofitListAPIClientInstance

object UserRepository {

    val apiService = RetrofitClientInstance.apiService

    val userApiService = RetrofitListAPIClientInstance.apiService

    suspend fun doLogin(user: User): LoginResponse {
        return apiService.login(user)
    }

    suspend fun fetchUsers(): UsersListResponse {
        return userApiService.fetchUsers()
    }

}