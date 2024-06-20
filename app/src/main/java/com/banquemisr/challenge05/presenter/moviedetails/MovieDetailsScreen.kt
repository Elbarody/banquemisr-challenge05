package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailsScreen() {
    Scaffold(
        topBar = { MovieTopBar() },
    ) {
        MovieDetailsContent(it)
    }
}



@Composable
@Preview
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}