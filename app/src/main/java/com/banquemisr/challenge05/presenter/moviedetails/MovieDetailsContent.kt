package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import com.banquemisr.challenge05.utility.uitheme.MovieTypography

@Composable
fun MovieDetailsContent(paddingValues: PaddingValues, movieDetails: MovieDetails) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        MovieDetailsPoster(movieDetails.posterPath)
        MovieDetailsTitle(movieDetails.title)
        RunTimeAndReleaseDate(movieDetails)
        MovieDetailsDescription(movieDetails.overview)
        GenreSection(movieDetails.genres)
    }
}

@Composable
fun MovieDetailsDescription(overview: String?) {
    Text(
        text =overview.orEmpty(),  modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        style = MovieTypography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MovieDetailsTitle(title: String?) {
    Text(
        text = title.orEmpty(),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        style = MovieTypography.titleLarge,
        textAlign = TextAlign.Center
    )
}


