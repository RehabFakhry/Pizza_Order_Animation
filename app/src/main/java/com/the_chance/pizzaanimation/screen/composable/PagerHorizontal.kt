package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.the_chance.pizzaanimation.R
import com.the_chance.pizzaanimation.screen.PizzaUiState
import com.the_chance.pizzaanimation.screen.PizzaViewModel
import com.the_chance.pizzaanimation.ui.theme.space10
import com.the_chance.pizzaanimation.ui.theme.space16
import com.the_chance.pizzaanimation.ui.theme.space32
import com.the_chance.pizzaanimation.ui.theme.space8

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerHorizontal(state: PizzaUiState){
    val pagerState = rememberPagerState()
    val images = listOf(
        R.drawable.bread_1, R.drawable.bread_2,
        R.drawable.bread_3,R.drawable.bread_4)

    HorizontalImages(
        state = state,
        onClickImage = { },
        pagerState = pagerState,
        images = images,
        modifier = Modifier.wrapContentSize().padding(top= space8)
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalImages(
    onClickImage: (Any?) -> Unit,
    pagerState: PagerState,
    images: List<Int>,
    state: PizzaUiState,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        state = pagerState,
        count = images.size,
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = space32),
        modifier = modifier.fillMaxWidth(),
    ) {
        val animatedScale by animateFloatAsState(
            targetValue = if (it == pagerState.currentPage) 1f else 0.7f,
            animationSpec = tween(durationMillis = 200)
        )

        val targetSize = when {
            state.smallSelected -> animateDpAsState(190.dp)
            state.mediumSelected  -> animateDpAsState(220.dp)
            state.largeSelected  -> animateDpAsState(250.dp)
            else -> animateDpAsState(220.dp)
        }

        Image(
            painter = painterResource(id = images[it % images.size]),
            contentDescription = "",
            modifier = Modifier
                .scale(animatedScale)
                .clip(MaterialTheme.shapes.extraSmall)
                .size(targetSize.value)
                .padding(start = space10)
                .clickable
                { onClickImage(images[it % images.size]) }
        )
    }
}