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
import com.banquemisr.challenge05.utility.uitheme.MovieTypography

@Composable
fun MovieDetailsContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        MovieDetailsPoster()
        MovieDetailsTitle()
        RunTimeAndReleaseDate()
        MovieDetailsDescription()
    }
}

@Composable
fun MovieDetailsDescription() {
    Text(
        text = "When a young American woman is sent to Rome to begin a life of service to the church, she encounters a darkness that causes her to question her own faith and uncovers a terrifying conspiracy that hopes to bring about the birth of evil incarnate. “The First Omen” stars Nell Tiger Free (“Servant”), Tawfeek Barhom (“Mary Magdalene”), Sonia Braga (“Kiss of the Spider Woman”), Ralph Ineson (“The Northman”), and Bill Nighy (“Living”).\n" +
                "\n" +
                "The film is directed by Arkasha Stevenson based on characters created by David Seltzer (“The Omen”), with a story by Ben Jacoby (“Bleed”) and a screenplay by Tim Smith & Arkasha Stevenson and Keith Thomas (“Firestarter”). The producers are David S. Goyer (“Hellraiser”) and Keith Levine (“The Night House”) and the executive producers are Tim Smith, Whitney Brown (“Rosaline”), and Gracie Wheelan.",
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        style = MovieTypography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MovieDetailsTitle() {
    Text(
        text = "Movie Title",
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        style = MovieTypography.titleLarge,
        textAlign = TextAlign.Center
    )
}


