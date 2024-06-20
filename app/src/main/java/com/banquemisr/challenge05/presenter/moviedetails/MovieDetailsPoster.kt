package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MovieDetailsPoster(posterPath: String?) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val imageHeight = screenHeight * 0.4f

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(imageHeight),
        painter = rememberAsyncImagePainter(model = posterPath),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )
}

@Composable
@Preview
fun MovieDetailsPosterPreview() {
    MovieDetailsPoster("")
}