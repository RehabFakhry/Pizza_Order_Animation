package com.the_chance.pizzaanimation.screen

import androidx.lifecycle.ViewModel
import com.the_chance.pizzaanimation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(Pizza())
    val state = _state.asStateFlow()

    init {
        getAllIngredient()
    }

    private fun getAllIngredient() {
        _state.update {
            it.copy(
                ingredients =
                listOf(
                    R.drawable.basil_2,
                    R.drawable.broccoli_1,
                    R.drawable.mushroom_5,
                    R.drawable.onion_3,
                    R.drawable.sausage_3,
                )
            )
        }
    }

    fun onSelectIngredient(pizzaId: Int, ingredientId: Int) {
        _state.update { pizza ->
            pizza.copy(
                pizzas = pizza.pizzas.mapIndexed { index, pizzaUiState ->
                    if (index == pizzaId) {
                        pizzaUiState.copy(
                            ingredients = pizza.pizzas[pizzaId].ingredients.mapIndexed { ingredientIndex, ingredientUiState ->
                                if (ingredientIndex == ingredientId) {
                                    ingredientUiState.copy(
                                        ingredientSelected = !ingredientUiState.ingredientSelected
                                    )
                                } else {
                                    ingredientUiState
                                }
                            }
                        )
                    } else {
                        pizzaUiState
                    }
                }
            )
        }
    }

    fun onClickSmallSize(pizzaId: Int) {
        _state.update { state ->
            state.copy(
                pizzas = state.pizzas.mapIndexed { index, pizzaUiState ->
                    if (pizzaId == index) {
                        pizzaUiState.copy(
                            smallSelected = !pizzaUiState.smallSelected,
                            mediumSelected = false,
                            largeSelected = false,
                        )
                    } else {
                        pizzaUiState
                    }
                }
            )
        }
    }

    fun onClickMediumSize(pizzaId: Int) {
        _state.update { state ->
            state.copy(
                pizzas = state.pizzas.mapIndexed { index, pizzaUiState ->
                    if (pizzaId == index) {
                        pizzaUiState.copy(
                            smallSelected = false,
                            mediumSelected = !pizzaUiState.mediumSelected,
                            largeSelected = false,
                        )
                    } else {
                        pizzaUiState
                    }
                }
            )
        }
    }

    fun onClickLargeSize(pizzaId: Int) {
        _state.update { state ->
            state.copy(
                pizzas = state.pizzas.mapIndexed { index, pizzaUiState ->
                    if (pizzaId == index) {
                        pizzaUiState.copy(
                            smallSelected = false,
                            mediumSelected = false,
                            largeSelected = !pizzaUiState.largeSelected,
                        )
                    } else {
                        pizzaUiState
                    }
                }
            )
        }
    }
}
