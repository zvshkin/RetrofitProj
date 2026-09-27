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

    fun deleteUser(id: Int) {
        viewModelScope.launch {
            try {
                val api: UserInterface = RetrofitClient.retrofitAPI
                val user = api.deleteUser(id)
                Log.d("UserViewModel", "Пользователь удален:\n" +
                        "ID: ${user.id}\n" +
                        "Имя: ${user.firstName}\n" +
                        "Фамилия: ${user.lastName}\n" +
                        "Username: ${user.username}\n" +
                        "Роль: ${user.role}\n" +
                        "isDeleted: ${user.isDeleted}\n" +
                        "deletedOn: ${user.deletedOn}")
            } catch (e: Exception) {
                Log.e("UserViewModel", "Ошибка при удалении: ${e.message}", e)
            }
        }
    }
}