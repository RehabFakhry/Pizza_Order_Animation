package com.the_chance.pizzaanimation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.the_chance.pizzaanimation.R
import com.the_chance.pizzaanimation.screen.composable.ButtonWithIcon
import com.the_chance.pizzaanimation.screen.composable.CardSelected
import com.the_chance.pizzaanimation.screen.composable.LazyRawIngredient
import com.the_chance.pizzaanimation.screen.composable.PagerHorizontal
import com.the_chance.pizzaanimation.screen.composable.SpacerVertical
import com.the_chance.pizzaanimation.ui.theme.space16
import com.the_chance.pizzaanimation.ui.theme.space200
import com.the_chance.pizzaanimation.ui.theme.space24
import com.the_chance.pizzaanimation.ui.theme.space4
import com.the_chance.pizzaanimation.ui.theme.space480
import com.the_chance.pizzaanimation.ui.theme.space8
import com.the_chance.pizzaanimation.ui.theme.textSize24
import com.the_chance.pizzaanimation.ui.theme.textSize32


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.back))
                    }
                },
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.App_Name),
                            fontSize = textSize24,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Favorite, stringResource(R.string.favorite))
                    }
                },
            )
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(bottom = space200)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plate),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.5f)
                )
                PagerHorizontal(state = state, viewModel)

                Box(modifier = Modifier){
                    Image(rememberAsyncImagePainter(model = state.ingredientImage), contentDescription = null )
                }
            }

            Column(
                modifier = Modifier
                    .padding(top = space480)
                    .fillMaxWidth()
                    .padding(horizontal = space16),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            )
            {
                Text(
                    modifier = Modifier.padding(top = space4),
                    text = stringResource(R.string._17),
                    fontSize = textSize32,
                    fontWeight = FontWeight.Bold
                )

                SpacerVertical(height = space16)
                Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
                    CardSelected(title = stringResource(R.string.s), viewModel::onClickSmallSize)
                    CardSelected(title = stringResource(R.string.m), viewModel::onClickMediumSize)
                    CardSelected(title = stringResource(R.string.l), viewModel::onClickLargeSize)
                }
                SpacerVertical(height = space24)
                Text(
                    text = stringResource(R.string.customize_your_pizza),
                    fontWeight = FontWeight.Light,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 240.dp)
                )
                SpacerVertical(height = space8)
                LazyRawIngredient()
                SpacerVertical(height = space8)
                ButtonWithIcon(
                    text = stringResource(R.string.add_to_cart),
                    iconResId = R.drawable.icon_cart, {})
                SpacerVertical(height = space24)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPizzaScreen() {
    PizzaScreen()
}