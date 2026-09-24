package com.example.retrofitproj.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitproj.data.RetrofitClient
import com.example.retrofitproj.data.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    fun fetch(id: Int) {
        viewModelScope.launch {
            try {
                val recipe = RetrofitClient.recipeAPI.getRecipe(id)
                Log.d("RecipeViewModel", "до редактирования")
                Log.d(
                    "RecipeViewModel",
                    "${recipe.id}\n${recipe.name}\n${recipe.ingredients}\n${recipe.cookTimeMinutes}\n${recipe.difficulty}",
                )
            } catch (e: Exception) {
                Log.e("RecipeViewModel", e.message.toString(), e)
            }
        }
    }

    fun updateRecipe(id: Int, recipe: Recipe) {
        viewModelScope.launch {
            try {
                val recipe = RetrofitClient.recipeAPI.updateRecipe(id, recipe)
                Log.d("RecipeViewModel", "после редактирования")
                Log.d(
                    "RecipeViewModel",
                    "${recipe.id}\n${recipe.name}\n${recipe.ingredients}\n${recipe.cookTimeMinutes}\n${recipe.difficulty}",
                )
            } catch (e: Exception) {
                Log.e("RecipeViewModel", e.message.toString(), e)
            }
        }
    }
}
