package com.example.retrofitproj.data.service

import com.example.retrofitproj.data.model.UsersResponse
import retrofit2.http.GET

interface UserInterface {
    @GET("users")
    suspend fun getUsers(): UsersResponse
}