package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.the_chance.pizzaanimation.R
import com.the_chance.pizzaanimation.screen.Pizza
import com.the_chance.pizzaanimation.ui.theme.space32
import com.the_chance.pizzaanimation.ui.theme.space8

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerHorizontal(
    state: Pizza,
    pagerState: PagerState
) {
    HorizontalImages(
        state = state,
        pagerState = pagerState,
        modifier = Modifier
            .wrapContentSize()
            .padding(top = space8)
    )
}

@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun HorizontalImages(
    pagerState: PagerState,
    state: Pizza,
    modifier: Modifier = Modifier,
) {
    HorizontalPager(
        state = pagerState,
        count = state.pizzas.size,
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = space32),
        modifier = modifier.fillMaxWidth(),
    ) { page ->
        val animatedScale by animateFloatAsState(
            targetValue = if (page == pagerState.currentPage) 1f else 0.7f,
            animationSpec = tween(durationMillis = 200)
        )

        val targetSize = when {
            state.pizzas[page].smallSelected -> animateDpAsState(190.dp)
            state.pizzas[page].mediumSelected -> animateDpAsState(230.dp)
            state.pizzas[page].largeSelected -> animateDpAsState(260.dp)
            else -> animateDpAsState(260.dp)
        }
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = state.pizzas[page].bread),
                contentDescription = stringResource(R.string.bread),
                modifier = Modifier
                    .scale(animatedScale)
                    .clip(MaterialTheme.shapes.extraSmall)
                    .size(targetSize.value)
            )
            state.pizzas[page].ingredients.forEach {
                AnimatedVisibility(
                    visible = it.ingredientSelected,
                    enter = scaleIn(initialScale = 20f),
                    exit = ExitTransition.None,
                ) {
                    Image(
                        painter = painterResource(id = it.ingredientGroup),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier.scale(0.6f)
                    )
                }
            }
        }
    }
}