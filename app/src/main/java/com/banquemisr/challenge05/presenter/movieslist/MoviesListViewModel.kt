package com.banquemisr.challenge05.presenter.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.challenge05.data.entity.MovieListItem
import com.banquemisr.challenge05.data.repo.MoviesListRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesListViewModel(private val moviesListRepo: MoviesListRepo) : ViewModel() {

    private val _state = MutableStateFlow(MovieCollectionState())
    val state: StateFlow<MovieCollectionState> = _state.asStateFlow()

    fun fetchPopularMovies() {
        val currentPage: Int = state.value.currentPage/*val totalPages: Int? = state.value.totalPages

        if (totalPages != null && currentPage >= totalPages) return
*/
        //val nextPage: Int = if (totalPages == null) 1 else currentPage.plus(1)

        viewModelScope.launch {
            kotlin.runCatching {
                moviesListRepo.getMoviesList("popular", 1)
            }.onSuccess {moviesResponse ->
                val moviesState = _state

                _state.update {
                    it.copy(
                        movies = (moviesState.value.movies + moviesResponse.moviesList),
                    )
                }

            }.onFailure {
                NavHomeViewModelSideEffect.ShowErrorToast(it.message)
            }
        }
    }
}

data class MovieCollectionState(
    val currentPage: Int = 1,
    val movies: List<MovieListItem> = listOf(),
    val totalPages: Int? = null,
)

sealed class NavHomeViewModelSideEffect {
    data class ShowErrorToast(val message: String? = null) : NavHomeViewModelSideEffect()
}