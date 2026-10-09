package com.example.retrofitproj.data

import com.example.retrofitproj.data.service.LoginInterface
import com.example.retrofitproj.data.service.ProductInterface
import com.example.retrofitproj.data.service.RecipeInterface
import com.example.retrofitproj.data.service.TodosInterface
import com.example.retrofitproj.data.service.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // val proxy = java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        // .proxy(proxy)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitSwagger: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.207.106.59:8090/api/collections/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI: UserInterface = retrofit.create(UserInterface::class.java)
    val productAPI: ProductInterface = retrofit.create(ProductInterface::class.java)
    val recipeAPI: RecipeInterface = retrofit.create(RecipeInterface::class.java)

    val loginAPI: LoginInterface = retrofitSwagger.create(LoginInterface::class.java)
    val todosAPI: TodosInterface = retrofitSwagger.create(TodosInterface::class.java)
}
