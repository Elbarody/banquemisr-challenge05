package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.get

@Composable
fun MovieDetailsScreen(movieId: Int, viewModel: MoviesDetailsViewModel, onBackClick: () -> Unit) {

    val movieDetails by viewModel.stateMovieDetails.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchMovieDetails(movieId)
    }

    Scaffold(
        topBar = { MovieTopBar(onBackClick) },
    ) {
        MovieDetailsContent(it, movieDetails)
    }
}



@Composable
@Preview
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen(1, MoviesDetailsViewModel(get())) {}
}