package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.banquemisr.challenge05.data.entity.MovieListItem
import org.koin.androidx.compose.get

@Composable
fun MoviesListWithTabScreen(
    viewModel: MoviesListViewModel,
    onNavigateToMyScreen: () -> Unit
){
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchPopularMovies()
    }

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            CategoriesTabLayout {
                MoviesList(state.movies)
            }
        }
    }

}

@Composable
@Preview
private fun MoviesListWithTabScreenPreview(){
    MoviesListWithTabScreen(viewModel = MoviesListViewModel(get()), onNavigateToMyScreen = { })
}