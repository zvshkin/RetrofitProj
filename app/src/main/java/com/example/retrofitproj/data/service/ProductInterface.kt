package com.example.retrofitproj.data.service

import com.example.retrofitproj.data.model.Product
import retrofit2.http.Body
import retrofit2.http.POST

interface ProductInterface {
    @POST("products/add")
    suspend fun addProduct(@Body product: Product): Product
}
