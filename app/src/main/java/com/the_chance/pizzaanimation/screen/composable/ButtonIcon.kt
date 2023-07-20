package com.the_chance.pizzaanimation.screen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.the_chance.pizzaanimation.ui.theme.space16
import com.the_chance.pizzaanimation.ui.theme.space8

@Composable
fun ButtonWithIcon(
    text: String,
    iconResId: Int,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier.wrapContentSize(),
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        shape = RoundedCornerShape(space8)
    ) {
        Row( modifier = Modifier) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null, tint = Color.White
            )
            SpacerHorizontal(space8)
            Text(
                text = text,
                color = Color.White
            )
        }
    }
}
