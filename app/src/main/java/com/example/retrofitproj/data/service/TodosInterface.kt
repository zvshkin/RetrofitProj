package com.example.retrofitproj.data.service

import com.example.retrofitproj.data.model.Todos
import retrofit2.http.GET
import retrofit2.http.Header

interface TodosInterface {
    @GET("todos/records")
    suspend fun getTodos(@Header("Authorization") token: String): Todos
}