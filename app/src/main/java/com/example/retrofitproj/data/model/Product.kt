package com.example.retrofitproj.data.model

data class Product(
    val id: Int? = null,
    val title: String,
    val price: Double,
    val dimensions: String,
    val weight: Double
)
