package com.the_chance.pizzaanimation.screen

import com.the_chance.pizzaanimation.R

data class Pizza(
    val pizzas: List<PizzaUiState> = breads,
    val ingredients: List<Int> = emptyList(),
    )

data class PizzaUiState(
    val bread: Int,
    val ingredients: List<IngredientUiState> = listOfIngredients,
    val smallSelected: Boolean = false,
    val mediumSelected: Boolean = false,
    val largeSelected: Boolean = false,
)

val listOfIngredients = listOf(
    IngredientUiState(0, R.drawable.basil_1, false, R.drawable.basil),
    IngredientUiState(1, R.drawable.broccoli_1, false, R.drawable.broccoli),
    IngredientUiState(2, R.drawable.mushroom_1, false, R.drawable.mushroom),
    IngredientUiState(3, R.drawable.onion_1, false, R.drawable.onion),
    IngredientUiState(4, R.drawable.sausage_1, false, R.drawable.sausage),
)

data class IngredientUiState(
    val id: Int,
    val image: Int,
    val ingredientSelected: Boolean = false,
    val ingredientGroup: Int,
)

val breads = listOf(
    PizzaUiState(R.drawable.bread_1),
    PizzaUiState(R.drawable.bread_2),
    PizzaUiState(R.drawable.bread_3),
    PizzaUiState(R.drawable.bread_4),
    PizzaUiState(R.drawable.bread_5),
)