package com.example.retrofitproj.data.model

data class User(
    val id: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val username: String? = null,
    val role: String? = null,
    val isDeleted: Boolean = false,
    val deletedOn: String? = null,
)