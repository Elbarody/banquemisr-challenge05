package com.banquemisr.challenge05.utility.uitheme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val MovieTypography = Typography(
  titleLarge = TextStyle(
    fontFamily = FontFamily.Cursive,
    fontWeight = FontWeight.Bold,
    color = Color.DarkGray,
    fontSize = 28.sp
  ),
  titleMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.SemiBold,
    color = Color.DarkGray,
    fontSize = 21.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    color = Color.Gray,
    fontSize = 16.sp
  ),
)