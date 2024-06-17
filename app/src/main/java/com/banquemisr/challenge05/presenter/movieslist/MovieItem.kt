package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.R

@Composable
fun MovieItem() {
    Card {
        Column(
            modifier = Modifier
                .width(150.dp)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MovieImage()
            MovieTitle()
            MovieDate()
        }
    }
}

@Composable
private fun MovieImage() {
    Image(
        // todo Replace test image with imageUrl
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.FillBounds,
        contentDescription = "Movie poster",
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 200.dp)
    )
}

@Composable
private fun MovieTitle() {
    Text(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        textAlign = TextAlign.Center,
        text = "titkkkkkkkkkkkkkkkkkkkkkle",
        style = TextStyle(
            fontSize = typography.titleMedium.fontSize,
            fontWeight = typography.titleMedium.fontWeight,
            color = MaterialTheme.colorScheme.onSurface,
            fontFamily = typography.titleMedium.fontFamily
        )
    )

}

@Composable
private fun MovieDate() {
    Text(text = "releaseDate", style = TextStyle(
        fontSize = typography.labelMedium.fontSize,
        fontWeight = typography.labelMedium.fontWeight,
        color = MaterialTheme.colorScheme.primary,
        fontFamily = typography.labelMedium.fontFamily
    ))

}

@Composable
@Preview
private fun MovieItemPreview() {
    MovieItem()
}