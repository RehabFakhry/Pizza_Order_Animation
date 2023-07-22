package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the_chance.pizzaanimation.ui.theme.space2
import com.the_chance.pizzaanimation.ui.theme.space24
import com.the_chance.pizzaanimation.ui.theme.space4

@Composable
fun CardSelected(
    title: String,
    onClick: (id: Int) -> Unit,
    id: Int,
    ) {
    Card(
        modifier = Modifier
            .size(width = 60.dp, height = 30.dp)
            .clickable { onClick(id) },
        colors = CardDefaults.cardColors(containerColor = White),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(space4)
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = space24)
            )
        }

    }
}