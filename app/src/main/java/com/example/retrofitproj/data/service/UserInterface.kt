package com.example.retrofitproj.data.service

import com.example.retrofitproj.data.model.User
import com.example.retrofitproj.data.model.UsersResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInterface {
    @GET("users")
    suspend fun getUsers(): UsersResponse

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Int): User
}