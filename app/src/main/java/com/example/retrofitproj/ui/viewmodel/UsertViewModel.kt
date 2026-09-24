package com.example.retrofitproj.ui.viewmodel

import android.util.Log
import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitproj.data.RetrofitClient
import com.example.retrofitproj.data.service.UserInterface
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    fun fetch() {
        viewModelScope.launch {
            try {
                val api: UserInterface = RetrofitClient.retrofitAPI
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