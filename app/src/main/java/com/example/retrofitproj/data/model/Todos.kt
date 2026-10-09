package com.example.retrofitproj.data.model

data class Todos(
    val items: List<Todo>? = null,
    val page: Int? = null,
    val perPage: Int? = null,
    val totalItems: Int? = null,
    val totalPages: Int? = null,
)
