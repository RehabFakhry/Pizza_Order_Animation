package com.the_chance.pizzaanimation.screen

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.the_chance.pizzaanimation.R
import com.the_chance.pizzaanimation.screen.composable.ButtonWithIcon
import com.the_chance.pizzaanimation.screen.composable.ChipSelected
import com.the_chance.pizzaanimation.screen.composable.LazyRawIngredient
import com.the_chance.pizzaanimation.screen.composable.PagerHorizontal
import com.the_chance.pizzaanimation.screen.composable.SpacerHorizontal
import com.the_chance.pizzaanimation.screen.composable.SpacerVertical
import com.the_chance.pizzaanimation.ui.theme.space16
import com.the_chance.pizzaanimation.ui.theme.space24
import com.the_chance.pizzaanimation.ui.theme.space4
import com.the_chance.pizzaanimation.ui.theme.textSize24
import com.the_chance.pizzaanimation.ui.theme.textSize32

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun PizzaScreen(
    viewModel: PizzaViewModel = hiltViewModel(),
    )
{
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    val pizzaId = pagerState.currentPage
    val offset by animateDpAsState(
        targetValue =
        if(state.pizzas[pagerState.currentPage].smallSelected) (-60).dp
        else if(state.pizzas[pagerState.currentPage].mediumSelected) 0.dp
        else (60).dp )

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
                modifier = Modifier.padding(bottom = 280.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plate),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.54f)
                )
                PagerHorizontal(state = state, pagerState = pagerState)

                Box(modifier = Modifier) {
                    Image(
                        rememberAsyncImagePainter(model = state.pizzas),
                        contentDescription = null
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 420.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = space16),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            )
            {
                Text(
                    modifier = Modifier.padding(top = space4),
                    text = stringResource(R.string._17),
                    fontSize = textSize32,
                    fontWeight = FontWeight.Medium
                )

                SpacerVertical(height = space24)
                Box(modifier = Modifier) {
                    Card(modifier = Modifier
                        .size(45.dp)
                        .align(Alignment.Center)
                        .offset (x= offset),
                        shape = CircleShape,
                        elevation = CardDefaults.cardElevation(20.dp),
                        colors = CardDefaults.cardColors(Color.White),
                    ){}
                    Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
                        ChipSelected(
                            text = stringResource(R.string.s),
                            viewModel::onClickSmallSize,
                            pizzaId, false
                        )
                        SpacerHorizontal(width = space16)
                        ChipSelected(
                            text = stringResource(R.string.m),
                            viewModel::onClickMediumSize,
                            pizzaId,false
                        )
                        SpacerHorizontal(width = space16)
                        ChipSelected(
                            text = stringResource(R.string.l),
                            viewModel::onClickLargeSize,
                            pizzaId, false
                        )
                    }
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
                SpacerVertical(height = space24)
                LazyRawIngredient(pizzaId)
                SpacerVertical(height = space24)
                ButtonWithIcon(
                    text = stringResource(R.string.add_to_cart),
                    iconResId = R.drawable.icon_cart, {})
                SpacerVertical(height = space16)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPizzaScreen() {
    PizzaScreen()
}