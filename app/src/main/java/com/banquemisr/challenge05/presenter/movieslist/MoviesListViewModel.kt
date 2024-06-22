package com.banquemisr.challenge05.presenter.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.banquemisr.challenge05.data.mappers.toMovie
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.map

class MoviesListViewModel(private val moviesListRepo: MoviesListRepo) : ViewModel() {

    val moviesNowPlayFlow = moviesListRepo.getNowPlayingMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

    val moviesPopularFlow = moviesListRepo.getPopularMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

    val moviesUpcomingFlow = moviesListRepo.getUpcomingMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

}

enum class MovieListType(val type: String) {
    NOW_PLAYING("now_playing"), POPULAR("popular"), UPCOMING("upcoming")
}