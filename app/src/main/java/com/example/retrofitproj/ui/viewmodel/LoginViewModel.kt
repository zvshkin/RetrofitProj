package com.example.retrofitproj.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitproj.data.RetrofitClient
import com.example.retrofitproj.data.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val authUser = RetrofitClient.loginAPI.authentication(loginRequest)
                Log.d("LoginViewModel", "Token: ${authUser.token}")
                Log.d("LoginViewModel", "User: ${authUser.record}")

                val token = authUser.token
                if (!token.isNullOrEmpty()) {
                    val todos = RetrofitClient.todosAPI.getTodos(token)
                    Log.d(
                        "LoginViewModel",
                        "items: ${todos.items}\n" +
                                "page: ${todos.page}\n" +
                                "perPage: ${todos.perPage}\n" +
                                "totalItems: ${todos.totalItems}\n" +
                                "totalPages: ${todos.totalPages}",
                    )
                }
            } catch (ex: Exception) {
                Log.e("LoginViewModel", ex.message, ex)
            }
        }
    }
}
