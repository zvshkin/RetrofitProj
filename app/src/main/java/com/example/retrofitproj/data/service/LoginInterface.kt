package com.example.retrofitproj.data.service

import com.example.retrofitproj.data.model.LoginRequest
import com.example.retrofitproj.data.model.LoginResponses
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("users/auth-with-password")
    suspend fun authentication(@Body loginRequest: LoginRequest): LoginResponses
}