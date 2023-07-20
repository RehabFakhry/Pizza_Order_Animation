package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.the_chance.pizzaanimation.screen.IngredientUiState
import com.the_chance.pizzaanimation.screen.PizzaUiState
import com.the_chance.pizzaanimation.screen.PizzaViewModel
import com.the_chance.pizzaanimation.ui.theme.BackgroundColor
import com.the_chance.pizzaanimation.ui.theme.space32

@Composable
fun LazyRawIngredient(
    viewModel: PizzaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val selectedIngredient = viewModel.selectedIngredient

    LazyRawContent(state = state){ selectedIngredient ->
        viewModel.setSelectedIngredient(selectedIngredient)}
}

@Composable
private fun LazyRawContent(
    state: PizzaUiState,
    onItemClick: (IngredientUiState) -> Unit
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(state.ingredients) {
            IngredientItem(state = it, onItemClick)
        }
    }
}

@Composable
fun IngredientItem(state: IngredientUiState, onItemClick: (IngredientUiState) -> Unit) {
    Card(
        modifier = Modifier,
        RoundedCornerShape(space32),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = state.image),
            contentDescription = null,
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
    }
}