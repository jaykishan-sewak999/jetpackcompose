package com.example.jetpackcomposedemo.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposedemo.neteork.APIService
import com.example.jetpackcomposedemo.neteork.LoginResponse
import com.example.jetpackcomposedemo.neteork.RetrofitClientInstance
import kotlinx.coroutines.launch

class SignInViewModel(val userRepository: UserRepository) : ViewModel() {

    var loginResponse: LoginResponse by mutableStateOf(LoginResponse(""))
    var isLoading: Boolean by mutableStateOf(false)

        fun doLogin(){
            isLoading = true
        viewModelScope.launch {
            try {
                loginResponse = userRepository.doLogin(User("test@test.com","123456"))
                loginResponse.isSuccess = true
                isLoading = false
            }
            catch (exception: Exception){
                isLoading = false
                loginResponse.isSuccess = false
                loginResponse.message = exception.message
            }
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