package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.the_chance.pizzaanimation.screen.PizzaUiState
import com.the_chance.pizzaanimation.screen.PizzaViewModel
import com.the_chance.pizzaanimation.ui.theme.space32

@Composable
fun LazyRawIngredient(
    pizza: Int,
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    LazyRawContent(state = state.pizzas[pizza],  pizza, viewModel::onSelectIngredient,)
}

@Composable
private fun LazyRawContent(
    state: PizzaUiState,
    pizza: Int,
    onClick: (Int, Int)-> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(5) {
            IngredientItem(state = state, it, pizza = pizza, onClick = onClick )
        }
    }
}

@Composable
fun IngredientItem(state: PizzaUiState , index: Int, onClick: (Int, Int) -> Unit,
pizza: Int) {
    Card(
        modifier = Modifier,
        RoundedCornerShape(space32),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = state.ingredients[index]),
            contentDescription = null,
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
                .clickable{onClick(pizza, index)},
            contentScale = ContentScale.Crop,
        )
    }
}