package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.R
import com.banquemisr.challenge05.utility.uitheme.MovieTypography

@Composable
fun MovieTopBar(onBackClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onBackClick.invoke()
            },
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = null
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Movie Details",
            style = MovieTypography.titleMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun MovieTopBarPreview() {
    MovieTopBar {}
}