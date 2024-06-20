package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.R
import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import com.banquemisr.challenge05.utility.formatDateToMonthDayYear
import com.banquemisr.challenge05.utility.formatToMinutesAndHours
import com.banquemisr.challenge05.utility.uitheme.MovieTypography

@Composable
fun RunTimeAndReleaseDate(movieDetails: MovieDetails) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RunTimeData(movieDetails.runtime)
        ReleaseDateData(movieDetails.releaseDate)
    }
}

@Composable
fun RunTimeData(runtime: Int?) {
    val spannableString = buildAnnotatedString{
        val style = SpanStyle(
            color = MovieTypography.titleSmall.color,
            fontWeight = MovieTypography.titleSmall.fontWeight,
            fontSize = MovieTypography.titleSmall.fontSize,
            fontFamily = MovieTypography.titleSmall.fontFamily
        )
        withStyle(style){
            append(stringResource(R.string.runtime))
        }
        pushStyle(style)
        withStyle(style.copy(fontWeight = FontWeight.Normal)){
            append(runtime?.let { formatToMinutesAndHours(it) })
        }
    }

    Text(text = spannableString)

}

@Composable
fun ReleaseDateData(releaseDate: String?) {
    val spannableString = buildAnnotatedString{
        val style = SpanStyle(
            color = MovieTypography.titleSmall.color,
            fontWeight = MovieTypography.titleSmall.fontWeight,
            fontSize = MovieTypography.titleSmall.fontSize,
            fontFamily = MovieTypography.titleSmall.fontFamily
        )
        withStyle(style){
            append(stringResource(R.string.release_date))
        }
        pushStyle(style)
        withStyle(style.copy(fontWeight = FontWeight.Normal)){
            append(formatDateToMonthDayYear(releaseDate.orEmpty()))
        }
    }

    Text(text = spannableString)

}