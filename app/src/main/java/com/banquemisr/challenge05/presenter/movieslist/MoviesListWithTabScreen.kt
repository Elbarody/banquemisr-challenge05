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
    val stateNowDisplay by viewModel.stateNowDisplay.collectAsState()
    val statePopular by viewModel.statePopular.collectAsState()
    val stateUpcoming by viewModel.stateUpcoming.collectAsState()

    var listType by remember { mutableStateOf(MovieListType.NOW_PLAYING.type) }

    LaunchedEffect(listType) {
        viewModel.fetchListMovies(listType)
    }

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            CategoriesTabLayout { page ->
                listType = when (page) {
                    0 -> MovieListType.NOW_PLAYING.type
                    1 -> MovieListType.POPULAR.type
                    2 -> MovieListType.UPCOMING.type
                    else -> listType
                }

                when (listType) {
                    MovieListType.NOW_PLAYING.type -> MoviesList(stateNowDisplay.movies)
                    MovieListType.POPULAR.type -> MoviesList(statePopular.movies)
                    MovieListType.UPCOMING.type -> MoviesList(stateUpcoming.movies)
                }
            }
        }
    }
}

@Composable
@Preview
private fun MoviesListWithTabScreenPreview(){
    MoviesListWithTabScreen(viewModel = MoviesListViewModel(get()), onNavigateToMyScreen = { })
}