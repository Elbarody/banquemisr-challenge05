package com.banquemisr.challenge05.presenter.movieslist

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.banquemisr.challenge05.data.entity.MovieListItem
import org.koin.androidx.compose.get

@Composable
fun MoviesListWithTabScreen(
    viewModel: MoviesListViewModel, onNavigateToMovieDetails: (Int) -> Unit
) {
    var listType by remember { mutableStateOf(MovieListType.NOW_PLAYING.type) }

    val nowPlayingMoviesListState: LazyPagingItems<MovieListItem> =
        viewModel.moviesNowPlayFlow.collectAsLazyPagingItems()

    val popularMoviesListState: LazyPagingItems<MovieListItem> =
        viewModel.moviesPopularFlow.collectAsLazyPagingItems()

    val upcomingMoviesListState: LazyPagingItems<MovieListItem> =
        viewModel.moviesUpcomingFlow.collectAsLazyPagingItems()

    val context = LocalContext.current
    LaunchedEffect(key1 = nowPlayingMoviesListState.loadState) {
        if (nowPlayingMoviesListState.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (nowPlayingMoviesListState.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
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
                    MovieListType.NOW_PLAYING.type -> {
                            MoviesList(nowPlayingMoviesListState) { movieId ->
                                onNavigateToMovieDetails.invoke(movieId)
                            }
                    }

                    MovieListType.POPULAR.type -> {
                        MoviesList(popularMoviesListState) { movieId ->
                            onNavigateToMovieDetails.invoke(movieId)
                        }
                    }

                    MovieListType.UPCOMING.type -> {
                        MoviesList(upcomingMoviesListState) { movieId ->
                            onNavigateToMovieDetails.invoke(movieId)
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview
private fun MoviesListWithTabScreenPreview() {
    MoviesListWithTabScreen(viewModel = MoviesListViewModel(get(), get(), get()), onNavigateToMovieDetails = { })
}