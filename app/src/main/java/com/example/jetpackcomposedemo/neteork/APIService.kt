package com.example.jetpackcomposedemo.neteork

import com.example.jetpackcomposedemo.signin.User
import com.example.jetpackcomposedemo.dashboard.UsersListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


private const val END_URL_LOGIN_WITH_EMAIL = "login_success"
private const val END_URL_EMPLOYEE_LIST = "employees"

interface APIService {

    @POST(END_URL_LOGIN_WITH_EMAIL)
    suspend fun login(@Body user: User): LoginResponse

    @GET(END_URL_EMPLOYEE_LIST)
    suspend fun fetchUsers(): UsersListResponse
}