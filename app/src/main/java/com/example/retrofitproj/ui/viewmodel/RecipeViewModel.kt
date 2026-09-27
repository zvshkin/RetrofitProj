package com.example.retrofitproj.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitproj.data.RetrofitClient
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    fun fetchAndUpdate(id: Int) {
        viewModelScope.launch {
            try {
                val fetchedRecipe = RetrofitClient.recipeAPI.getRecipe(id)
                Log.d("RecipeViewModel", "до редактирования")
                Log.d("RecipeViewModel", "${fetchedRecipe.id}\n${fetchedRecipe.name}...")

                val ingredients = listOf(
                    "Куриное филе",
                    "сливки",
                    "чеснок",
                    "сливочное масло",
                    "растительное масло",
                    "твердый сыр",
                    "соль",
                    "черный перец",
                    "итальянские травы"
                )

                val recipeToUpdate = fetchedRecipe.copy(
                    name = "Куриное филе в сливочно-чесночном соусе",
                    ingredients = ingredients,
                    cookTimeMinutes = 25,
                    difficulty = "Легкая"
                )

                val updatedRecipe = RetrofitClient.recipeAPI.updateRecipe(id, recipeToUpdate)
                Log.d("RecipeViewModel", "после редактирования")
                Log.d("RecipeViewModel", "${updatedRecipe.id}\n${updatedRecipe.name}...")
            } catch (e: Exception) {
                Log.e("RecipeViewModel", e.message.toString(), e)
            }
        }
    }
}
