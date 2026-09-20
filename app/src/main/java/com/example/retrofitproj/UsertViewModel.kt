package com.example.retrofitproj

import android.util.Log
import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitproj.service.UserInterface
import kotlinx.coroutines.launch

class UserViewModel(
    private val api: UserInterface = RetrofitClient.retrofitAPI
): ViewModel() {
    fun fetch() {
        viewModelScope.launch {
            try {
                val userResponse = api.getUsers()
                val users = userResponse.users
                for (user in users) {
                    Log.d("UserViewModel","Имя Фамилия: ${user.firstName} + ${user.lastName} Username: ${user.username} Роль: ${user.role}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}", e)
            }
        }
    }
}