package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.banquemisr.challenge05.R

@Composable
fun MovieDetailsScreen() {
    Scaffold(
        topBar = { MovieTopBar() },
    ) {
        Column(modifier = Modifier.padding(it)) {
            MovieDetailsPoster()
            RunTimeAndReleaseDate()
        }
    }
}


@Composable
fun MovieDetailsPoster() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.33f),
        painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with your image source
        contentDescription = null,
        contentScale = ContentScale.FillBounds
        // Other UI elements below the image
    )
}

@Composable
@Preview
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}