package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.the_chance.pizzaanimation.screen.Pizza
import com.the_chance.pizzaanimation.screen.PizzaViewModel
import com.the_chance.pizzaanimation.ui.theme.BackgroundColor
import com.the_chance.pizzaanimation.ui.theme.space16
import com.the_chance.pizzaanimation.ui.theme.space24
import com.the_chance.pizzaanimation.ui.theme.space32

@Composable
fun LazyRawIngredient(
    pizza: Int,
    viewModel: PizzaViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    LazyRawContent(state = state, pizza, viewModel::onSelectIngredient)
}

@Composable
private fun LazyRawContent(
    state: Pizza,
    pizza: Int,
    onClick: (Int, Int) -> Unit
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space24),
        contentPadding = PaddingValues(horizontal = space16)
    ) {
        items(5) {
            IngredientItem(state = state, index = it, pizza = pizza, onClick = onClick)
        }
    }
}

@Composable
fun IngredientItem(
    state: Pizza,
    index: Int,
    onClick: (Int, Int) -> Unit,
    pizza: Int,
) {

    var selectedIngredientIndex by remember { mutableStateOf(-1) }
    val isSelected = selectedIngredientIndex == index

    Card(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable {
                selectedIngredientIndex = if (isSelected) {
                    -1
                } else {
                    index
                }
                onClick(pizza, index)
            },
        RoundedCornerShape(space32),
        colors = if (isSelected) {
            CardDefaults.cardColors(BackgroundColor)
        } else {
            CardDefaults.cardColors(Color.White)
        }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = state.ingredients[index]),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
        )
    }
}