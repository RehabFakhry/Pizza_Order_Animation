package com.the_chance.pizzaanimation.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.the_chance.pizzaanimation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    private val _selectedIngredient = mutableStateOf<IngredientUiState?>(null)
    val selectedIngredient: IngredientUiState? get() = _selectedIngredient.value


    init {
        getAllIngredient()
    }

    private fun getAllIngredient() {
        _state.update {
            it.copy(
                ingredients = listOf(
                    IngredientUiState(R.drawable.basil_1),
                    IngredientUiState(R.drawable.broccoli_1),
                    IngredientUiState(R.drawable.mushroom_1),
                    IngredientUiState(R.drawable.onion_1),
                    IngredientUiState(R.drawable.sausage_1),
                    IngredientUiState(R.drawable.basil_2),
                    IngredientUiState(R.drawable.broccoli_2),
                    IngredientUiState(R.drawable.mushroom_2),
                    IngredientUiState(R.drawable.onion_2),
                    IngredientUiState(R.drawable.sausage_2),
                    IngredientUiState(R.drawable.basil_3),
                    IngredientUiState(R.drawable.broccoli_3),
                    IngredientUiState(R.drawable.mushroom_3),
                    IngredientUiState(R.drawable.onion_3),
                    IngredientUiState(R.drawable.sausage_3),
                ),
            )
        }
    }

    fun getAllIngredientImage() {
        _state.update {
            it.copy(
                ingredientImage = listOf(
                    IngredientWholeImage(R.drawable.basil),
                    IngredientWholeImage(R.drawable.broccoli),
                    IngredientWholeImage(R.drawable.mushroom),
                    IngredientWholeImage(R.drawable.onion),
                    IngredientWholeImage(R.drawable.basil),
                    IngredientWholeImage(R.drawable.broccoli),
                    IngredientWholeImage(R.drawable.mushroom),
                    IngredientWholeImage(R.drawable.onion),
                ),
            )
        }
    }

    fun setSelectedIngredient(ingredient: IngredientUiState) {
        _selectedIngredient.value = ingredient
    }

    fun onClickSmallSize() {
        _state.update {
            it.copy(
                smallSelected = !it.smallSelected,
                mediumSelected = false,
                largeSelected = false,
            )
        }
    }

    fun onClickMediumSize() {
        _state.update {
            it.copy(
                smallSelected = false,
                mediumSelected = !it.mediumSelected,
                largeSelected = false,
            )
        }
    }

    fun onClickLargeSize() {
        _state.update {
            it.copy(
                smallSelected = false,
                mediumSelected = false,
                largeSelected = !it.largeSelected,
            )
        }
    }
}

//    fun onClickIngredient(IngredientIndex: Int, currentIngredient: Int) {
//        _state.update {
//            it.copy(
//                it.pizza.mapIndexed { pizzaIndex, pizza ->
//                    if (pizzaIndex == currentIngredient) {
//                        pizza.copy(
//                            ingredient = pizza.ingredient.mapIndexed { index, ingredient ->
//                                if (index == IngredientIndex) {
//                                    ingredient.copy(isSelectedIngredient = !ingredient.isSelectedIngredient)
//                                } else {
//                                    ingredient.copy(isSelectedIngredient = ingredient.isSelectedIngredient)
//                                }
//                            },
//                        )
//                    } else {
//                        pizza.copy(
//                            ingredient = pizza.ingredient.mapIndexed { index, ingredient ->
//                                ingredient.copy(isSelectedIngredient = ingredient.isSelectedIngredient)
//                            },
//                        )
//                    }
//                },
//                currentPage = currentIngredient,
//            )
//        }
//    }
//}

//    private fun getAllIngredient() {
//        _state.update {
//            it.copy(pizza = it.pizza.map {
//                it.copy(
//                    ingredient = listOf(
//                        IngredientUiState(imageIcon = R.drawable.basil_1, image = R.drawable.basil),
//                        IngredientUiState(
//                            imageIcon = R.drawable.broccoli_1,
//                            image = R.drawable.broccoli
//                        ),
//                        IngredientUiState(
//                            imageIcon = R.drawable.sausage_1,
//                            image = R.drawable.sausage
//                        ),
//                        IngredientUiState(imageIcon = R.drawable.onion_1, image = R.drawable.onion),
//                        IngredientUiState(
//                            imageIcon = R.drawable.mushroom_1,
//                            image = R.drawable.mushroom
//                        ),
//                    )
//                )
//            }
//            )
//        }
//    }