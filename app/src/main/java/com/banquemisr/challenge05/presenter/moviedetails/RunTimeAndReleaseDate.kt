package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import com.banquemisr.challenge05.utility.formatDateToMonthDayYear
import com.banquemisr.challenge05.utility.formatToMinutesAndHours
import java.util.Locale

@Composable
fun RunTimeAndReleaseDate() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        RunTimeData()
        ReleaseDateData()
    }
}

@Composable
fun RunTimeData(){
    val spannableString = buildAnnotatedString{
        val style = SpanStyle(
            color = MaterialTheme.typography.titleSmall.color,
            fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            fontFamily = MaterialTheme.typography.titleSmall.fontFamily
        )
        withStyle(style){
            append(stringResource(R.string.runtime))
        }
        pushStyle(style)
        withStyle(style.copy(fontWeight = FontWeight.Normal)){
            append(formatToMinutesAndHours(5))
        }
    }

    Text(text = spannableString)

}

@Composable
fun ReleaseDateData(){
    val spannableString = buildAnnotatedString{
        val style = SpanStyle(
            color = MaterialTheme.typography.titleSmall.color,
            fontWeight = MaterialTheme.typography.titleSmall.fontWeight,
            fontSize = MaterialTheme.typography.titleSmall.fontSize,
            fontFamily = MaterialTheme.typography.titleSmall.fontFamily
        )
        withStyle(style){
            append(stringResource(R.string.release_date))
        }
        pushStyle(style)
        withStyle(style.copy(fontWeight = FontWeight.Normal)){
            append(formatDateToMonthDayYear("2023-01-01"))
        }
    }

    Text(text = spannableString)

}