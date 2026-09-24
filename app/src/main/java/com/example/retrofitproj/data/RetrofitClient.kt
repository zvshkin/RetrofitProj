package com.example.retrofitproj.data

import com.example.retrofitproj.data.service.ProductInterface
import com.example.retrofitproj.data.service.RecipeInterface
import com.example.retrofitproj.data.service.UserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // val proxy = java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress("10.207.106.59", 3128))

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        // .proxy(proxy)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitAPI: UserInterface = retrofit.create(UserInterface::class.java)
    val productAPI: ProductInterface = retrofit.create(ProductInterface::class.java)
    val recipeAPI: RecipeInterface = retrofit.create(RecipeInterface::class.java)
}
