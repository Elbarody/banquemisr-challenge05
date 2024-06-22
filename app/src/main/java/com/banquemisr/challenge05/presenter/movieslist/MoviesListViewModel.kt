package com.banquemisr.challenge05.presenter.movieslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.banquemisr.challenge05.data.mappers.toMovie
import com.banquemisr.challenge05.domin.nowdisplay_usecase.NowPlayUseCase
import com.banquemisr.challenge05.domin.popular_usecase.PopularListUseCase
import com.banquemisr.challenge05.domin.upcoming_usecase.UpcomingListUseCase
import kotlinx.coroutines.flow.map

class MoviesListViewModel(
    nowPlayingUseCase: NowPlayUseCase,
    upcomingUseCase: UpcomingListUseCase,
    popularUseCase: PopularListUseCase
) : ViewModel() {

    val moviesNowPlayFlow = nowPlayingUseCase.getNowPlayingMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

    val moviesPopularFlow = popularUseCase.getPopularMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

    val moviesUpcomingFlow = upcomingUseCase.getUpcomingMoviesList()
        .map { pagingData -> pagingData.map { it.toMovie() } }.cachedIn(viewModelScope)

}

enum class MovieListType(val type: String) {
    NOW_PLAYING("now_playing"), POPULAR("popular"), UPCOMING("upcoming")
}