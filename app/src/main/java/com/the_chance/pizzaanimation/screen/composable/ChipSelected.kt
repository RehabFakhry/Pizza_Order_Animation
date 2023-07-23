package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the_chance.pizzaanimation.ui.theme.LightGrey

@Composable
fun ChipSelected(
    text: String,
    onClick: (id: Int) -> Unit,
    id: Int,
    isSelected: Boolean,
) {
    Card(
        modifier = Modifier
            .size(45.dp)
            .clickable { onClick(id) },
        shape = CircleShape,
        colors = CardDefaults.cardColors(LightGrey),
        elevation = CardDefaults.cardElevation(2.dp),
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W300,
            modifier = Modifier.padding(start = 15.dp, top = 5.dp)
        )
    }
}