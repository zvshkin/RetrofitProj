package com.example.retrofitproj.service

import com.example.retrofitproj.model.Product
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductInterface {
    @POST("products/add")
    suspend fun addProduct(@Body product: Product): Product
}
