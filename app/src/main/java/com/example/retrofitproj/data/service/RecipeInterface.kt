package com.example.retrofitproj.data.service

import com.example.retrofitproj.data.model.Recipe
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface RecipeInterface {
    @GET("recipes/{id}")
    suspend fun getRecipe(@Path("id") id: Int): Recipe

    @PUT("recipes/{id}")
    suspend fun updateRecipe(@Path("id") id: Int, @Body recipe: Recipe): Recipe
}
