package com.example.retrofitproj.service

import com.example.retrofitproj.model.UsersResponse
import retrofit2.http.GET

interface UserInterface {
    @GET("users")
    suspend fun getUsers(): UsersResponse
}