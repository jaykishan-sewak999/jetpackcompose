package com.example.jetpackcomposedemo.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposedemo.signin.UserRepository
import kotlinx.coroutines.launch

class UsersListViewModel(val userRepository: UserRepository): ViewModel() {

    var usersListResponse: UsersListResponse by mutableStateOf(UsersListResponse())


    fun fetchUsers(){
        viewModelScope.launch {

            try {
                usersListResponse = userRepository.fetchUsers()
            }
            catch (exception:Exception){
                usersListResponse.status = "Fail"
            }

        }
    }

}