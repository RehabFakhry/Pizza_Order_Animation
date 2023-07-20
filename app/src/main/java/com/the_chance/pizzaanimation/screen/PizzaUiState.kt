package com.the_chance.pizzaanimation.screen


data class PizzaUiState(
    val ingredients: List<IngredientUiState> = emptyList(),
    val ingredientImage: List<IngredientWholeImage> = emptyList(),
    val smallSelected: Boolean = false,
    val mediumSelected: Boolean = false,
    val largeSelected: Boolean = false,
    val ingredientSelected: Boolean = false,
)

data class IngredientUiState(
    val image: Int,
)

data class IngredientWholeImage(
    val image: Int,
)

//data class PizzaSize(
//    val smallSelected: Boolean = false,
//    val mediumSelected: Boolean = false,
//    val largeSelected: Boolean = false,
//)