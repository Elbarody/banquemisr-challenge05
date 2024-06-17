package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItem(
    category: String,
    index: Int,
    selectedIndex: Int,
    onItemClicked: (Int) -> Unit
) {
    val isSelected = selectedIndex == index

    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color.Blue else Color.White,
        animationSpec = tween(durationMillis = 500)
    )
    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.DarkGray,
        animationSpec = tween(durationMillis = 500)
    )
    val borderColor by animateColorAsState(
        targetValue = if (isSelected) Color.Blue else Color.DarkGray,
        animationSpec = tween(durationMillis = 500)
    )

    Text(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                shape = RoundedCornerShape(10.dp),
                width = 1.dp,
                color = borderColor
            )
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() }, indication = null
            ) {
                onItemClicked(index)
            },
        text = category,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),
        color = textColor
    )
}

@Composable
@Preview
fun CategoryItemPreview() {
    CategoryItem("item", 1, 1, {})
}
