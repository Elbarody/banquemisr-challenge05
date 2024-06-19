package com.banquemisr.challenge05.utility.uitheme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MovieColorPalette = lightColorScheme(
    background = Color.White,
    surface = Color.White,
    primary = Color.Blue,
    secondary = Color.DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White
)

@Composable
fun MovieComposeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MovieColorPalette,
        typography = MovieTypography,
        shapes = shapes,
        content = content
    )
}