package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the_chance.pizzaanimation.ui.theme.Purple80
import com.the_chance.pizzaanimation.ui.theme.space0
import com.the_chance.pizzaanimation.ui.theme.space4
import com.the_chance.pizzaanimation.ui.theme.space8

@Composable
fun CardSelected(
    title: String,
    onClick: (id: Int) -> Unit,
    id: Int,
    isSelected: Boolean,
) {
    Card(
        modifier = Modifier
            .size(width = 45.dp, height = 30.dp)
            .clickable { onClick(id) },
//        colors = CardDefaults.cardColors(White),
        colors = if (isSelected) {
            CardDefaults.cardColors(Blue)
        } else {
            CardDefaults.cardColors(LightGray)
        },
        shape = CircleShape,
        elevation = if(isSelected) {
            CardDefaults.cardElevation(space4)
        } else {
            CardDefaults.cardElevation(space0)
        }
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 14.dp)
        )
    }
}