package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MoviesListWithTabScreen(){
    CategoriesTabLayout {
        MoviesList()
    }
}

@Composable
@Preview
private fun MoviesListWithTabScreenPreview(){
    MoviesListWithTabScreen()
}