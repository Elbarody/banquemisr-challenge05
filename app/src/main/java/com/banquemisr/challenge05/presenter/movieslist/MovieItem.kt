package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.banquemisr.challenge05.data.entity.MovieListItem

@Composable
fun MovieItem(movieListItem: MovieListItem, onItemClick: (Int) -> Unit) {
    Card(onClick = { onItemClick(movieListItem.id) }) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MovieImage(movieListItem.image)
            MovieTitle(movieListItem.title)
            MovieDate(movieListItem.releaseDate)
        }
    }
}

@Composable
private fun MovieImage(image: String) {
    Image(
        painter = rememberAsyncImagePainter(model = image),
        contentScale = ContentScale.FillBounds,
        contentDescription = "Movie poster",
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 300.dp)
    )
}

@Composable
private fun MovieTitle(title: String) {
    Text(
        modifier = Modifier.padding(horizontal = 8.dp),
        textAlign = TextAlign.Center,
        text = title,
        maxLines = 2,
        minLines = 2,
        overflow = TextOverflow.Ellipsis,

        style = TextStyle(
            fontSize = typography.titleMedium.fontSize,
            fontWeight = typography.titleMedium.fontWeight,
            color = MaterialTheme.colorScheme.onSurface,
            fontFamily = typography.titleMedium.fontFamily
        )
    )

}

@Composable
private fun MovieDate(releaseDate: String) {
    Text(
        text = releaseDate, style = TextStyle(
            fontSize = typography.labelMedium.fontSize,
            fontWeight = typography.labelMedium.fontWeight,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = typography.labelMedium.fontFamily
        )
    )

}

@Composable
@Preview
private fun MovieItemPreview() {
    MovieItem(movieListItem = MovieListItem(0, "", "", "")){}
}