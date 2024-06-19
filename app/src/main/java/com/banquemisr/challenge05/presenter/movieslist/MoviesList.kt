package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.data.entity.MovieListItem

@Composable
fun MoviesList(movies: List<MovieListItem>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movies[index])
        }
    }
}

@Composable
@Preview
private fun MoviesListPreview() {
    MoviesList(movies = listOf() )
}