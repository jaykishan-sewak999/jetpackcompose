package com.example.jetpackcomposedemo.neteork

import com.example.jetpackcomposedemo.signin.User
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST
    suspend fun login(@Body user: User): LoginResponse
}