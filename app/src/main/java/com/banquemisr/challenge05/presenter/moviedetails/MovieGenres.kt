package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.R
import com.banquemisr.challenge05.utility.uitheme.MovieTypography

val movieGenres = listOf(
    "Action", "Adventure", "Comedy", "Drama", "Fantasy",
    "Science Fiction", "Horror", "Thriller", "Romance", "Mystery",
    "Animation", "Musical", "Western", "Documentary", "Biography",
    "Longer Genre Name Example", "Another Longer Genre Name for Demonstration"
)
@Composable
fun GenreSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()){
        Text(
            text = stringResource(R.string.genres),
            style = MovieTypography.titleMedium
        )
        ListGenreGrid()
    }
}

@Composable
fun ListGenreGrid() {
    LazyVerticalGrid(
        modifier = Modifier.heightIn(max=300.dp),
        columns = GridCells.Fixed(3),
        userScrollEnabled = false,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieGenres) { genre ->
            GenreItem(genre = genre)
        }
    }
}

@Composable
fun GenreItem(
    genre: String,
) {
    Text(
        modifier = Modifier
            .background(
                color = Color.Blue,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 6.dp, vertical = 4.dp),
        text = genre,
        style = MovieTypography.bodySmall.copy(
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        ),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewDynamicGenreGrid() {
    GenreSection()
}
