package com.example.retrofitproj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.retrofitproj.data.model.Product
import com.example.retrofitproj.data.model.Recipe
import com.example.retrofitproj.ui.viewmodel.ProductViewModel
import com.example.retrofitproj.ui.viewmodel.RecipeViewModel
import com.example.retrofitproj.ui.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val userViewModel: UserViewModel = viewModel()
            val productViewModel: ProductViewModel = viewModel()

            val product = Product(
                title = "Робот-пылесос CleanBotMax",
                price = 33600.0,
                dimensions = "350 x 350 x 95",
                weight = 3.5
            )

            productViewModel.createProduct(product)
            userViewModel.fetch()

            val recipeViewModel: RecipeViewModel = viewModel()
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
            val recipe = Recipe(
                id = 11,
                name = "Куриное филе в сливочно-чесночном соусе",
                ingredients = ingredients,
                cookTimeMinutes = 25,
                difficulty = "Легкая"
            )

            recipeViewModel.fetch(11)
            recipeViewModel.updateRecipe(11, recipe)
        }
    }
}
