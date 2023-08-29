package com.example.jetpackcomposedemo.neteork

import com.example.jetpackcomposedemo.signin.User
import retrofit2.http.Body
import retrofit2.http.POST


private const val END_URL_LOGIN_WITH_EMAIL = "login_success"

interface APIService {

    @POST(END_URL_LOGIN_WITH_EMAIL)
    suspend fun login(@Body user: User): LoginResponse
}