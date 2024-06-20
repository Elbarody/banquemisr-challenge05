package com.banquemisr.challenge05.presenter.moviedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.banquemisr.challenge05.R

@Composable
fun MovieTopBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = null
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Movie Details",
            style = typography.titleMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun MovieTopBarPreview() {
    MovieTopBar()
}