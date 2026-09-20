package com.example.retrofitproj

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitproj.model.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    fun createProduct(product: Product) {
        viewModelScope.launch {
            try {
                val addedProduct = RetrofitClient.productAPI.addProduct(product)
                Log.d("ProductViewModel", "Добавлен продукт:\n" +
                        "ID: ${addedProduct.id}\n" +
                        "Название: ${addedProduct.title}\n" +
                        "Цена: ${addedProduct.price}\n" +
                        "Размеры: ${addedProduct.dimensions}\n" +
                        "Вес: ${addedProduct.weight}")
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Ошибка при добавлении: ${e.message}", e)
            }
        }
    }
}
