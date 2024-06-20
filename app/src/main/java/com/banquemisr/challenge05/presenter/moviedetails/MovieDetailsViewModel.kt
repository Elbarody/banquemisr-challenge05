package com.banquemisr.challenge05.presenter.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.challenge05.data.entity.moviedetails.MovieDetails
import com.banquemisr.challenge05.data.repo.moviedetails.MovieDetailsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoviesDetailsViewModel(private val movieDetailsRepo: MovieDetailsRepo) : ViewModel() {


    private val _stateMovieDetails = MutableStateFlow(MovieDetails())
    val stateMovieDetails: StateFlow<MovieDetails> = _stateMovieDetails.asStateFlow()

    fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            kotlin.runCatching {
                movieDetailsRepo.getMovieDetails(movieId)
            }.onSuccess { moviesResponse ->
                _stateMovieDetails.emit(moviesResponse)
            }.onFailure {

            }
        }
    }
}