package com.example.jetpackcomposedemo.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposedemo.neteork.APIService
import com.example.jetpackcomposedemo.neteork.LoginResponse
import com.example.jetpackcomposedemo.neteork.RetrofitClientInstance
import kotlinx.coroutines.launch

class SignInViewModel(val userRepository: UserRepository) : ViewModel() {

    var loginResponse: LoginResponse by mutableStateOf(LoginResponse(""))
    var errorMessage: String by mutableStateOf("")

    fun doLogin(){
        viewModelScope.launch {
            loginResponse = userRepository.doLogin(User("test@test.com","123456"))
        }
    }
}

class SignInViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}