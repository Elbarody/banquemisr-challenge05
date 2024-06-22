package com.banquemisr.challenge05.presenter.movieslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.banquemisr.challenge05.data.entity.MovieListItem

@Composable
fun MoviesList(movies: LazyPagingItems<MovieListItem>, onItemClick: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = PaddingValues(4.dp),
        state = rememberLazyListState()
    ) {
        items(movies.itemCount) { index ->
            if (movies.loadState.refresh is LoadState.NotLoading)
            MovieItem(movies[index], onItemClick)
        }
    }
}

@Composable
@Preview
private fun MoviesListPreview() {
/*
    MoviesList(movies = LazyPagingItems(emptyList()), onItemClick = {})){}
*/
}