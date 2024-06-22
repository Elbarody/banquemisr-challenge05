package com.banquemisr.challenge05.presenter.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.banquemisr.challenge05.data.entity.MovieListItem
import com.banquemisr.challenge05.data.mappers.toMovie
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

class MoviesListViewModel(private val moviesListRepo: MoviesListRepo) : ViewModel() {

    private val _stateNowDisplay = MutableStateFlow(MovieCollectionState())
    val stateNowDisplay: StateFlow<MovieCollectionState> = _stateNowDisplay.asStateFlow()

    private val _statePopular = MutableStateFlow(MovieCollectionState())
    val statePopular: StateFlow<MovieCollectionState> = _statePopular.asStateFlow()

    private val _stateUpcoming = MutableStateFlow(MovieCollectionState())
    val stateUpcoming: StateFlow<MovieCollectionState> = _stateUpcoming.asStateFlow()

    //this implementation is working for movies list
    /*@OptIn(ExperimentalPagingApi::class)
    fun fetchListMovies(type: String) {
        val currentPage: Int = when (type) {
            MovieListType.NOW_PLAYING.type -> _stateNowDisplay.value.currentPage
            MovieListType.POPULAR.type -> _statePopular.value.currentPage
            MovieListType.UPCOMING.type -> _stateUpcoming.value.currentPage
            else -> 1
        }

        val totalPages: Int? = when (type) {
            MovieListType.NOW_PLAYING.type -> _stateNowDisplay.value.totalPages
            MovieListType.POPULAR.type -> _statePopular.value.totalPages
            MovieListType.UPCOMING.type -> _stateUpcoming.value.totalPages
            else -> null
        }

        *//*if (totalPages != null && currentPage >= totalPages) return*//*

        val nextPage: Int = if (totalPages == null) 1 else currentPage.plus(1)

        viewModelScope.launch {
            kotlin.runCatching {
                moviesListRepo.getMoviesList()
            }.onSuccess { moviesResponse ->
                val moviesState = when (type) {
                    MovieListType.NOW_PLAYING.type -> _stateNowDisplay
                    MovieListType.POPULAR.type -> _statePopular
                    MovieListType.UPCOMING.type -> _stateUpcoming
                    else -> return@launch
                }

                moviesState.update {
                    it.copy(
                        movies = (it.movies + moviesResponse.moviesList),
                        currentPage = nextPage,
                        totalPages = moviesResponse.totalPages
                    )
                }
            }.onFailure {
                NavHomeViewModelSideEffect.ShowErrorToast(it.message)
            }
        }
    }*/

    val moviesNowPlayFlow = moviesListRepo.getNowPlayingMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

    val moviesPopularFlow = moviesListRepo.getPopularMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

    val moviesUpcaomnFlow = moviesListRepo.getUpcomingMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

}

data class MovieCollectionState(
    val currentPage: Int = 1,
    val movies: List<MovieListItem> = listOf(),
    val totalPages: Int? = null,
)

enum class MovieListType(val type: String) {
    NOW_PLAYING("now_playing"), POPULAR("popular"), UPCOMING("upcoming")
}