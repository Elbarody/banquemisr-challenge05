package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

    val backgroundColor = if (isSelected) Color.Blue else Color.White
    val textColor = if (isSelected) Color.White else Color.DarkGray
    val borderColor = if (isSelected) Color.Blue else Color.DarkGray

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
            .clickable {
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
