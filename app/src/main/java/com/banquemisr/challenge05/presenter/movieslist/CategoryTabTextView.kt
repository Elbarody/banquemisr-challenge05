package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TabTextView(isSelected: Boolean, categoryTitle: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isSelected) Color.Blue else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp, vertical = 4.dp),
        text = categoryTitle,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = if (isSelected) FontWeight.SemiBold
            else FontWeight.Medium,

            color = if (isSelected) Color.White else Color.DarkGray,
            textAlign = TextAlign.Center,
        )
    )
}