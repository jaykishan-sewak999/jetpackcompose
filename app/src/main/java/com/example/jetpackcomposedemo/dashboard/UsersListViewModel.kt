package com.example.jetpackcomposedemo.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposedemo.signin.SignInViewModel
import com.example.jetpackcomposedemo.signin.UserRepository
import kotlinx.coroutines.launch

class UsersListViewModel(val userRepository: UserRepository): ViewModel() {


    var usersListResponse: UsersListResponse by mutableStateOf(UsersListResponse())
    var isLoading: Boolean by mutableStateOf(false)


    fun fetchUsers(){
        isLoading = true
        viewModelScope.launch {

            try {
                usersListResponse = userRepository.fetchUsers()
                isLoading = false
            }
            catch (exception:Exception){
                usersListResponse.status = "Fail"
                isLoading = false
            }

        }
    }

}
class UsersListViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsersListViewModel::class.java)) {
            return UsersListViewModel(UserRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}