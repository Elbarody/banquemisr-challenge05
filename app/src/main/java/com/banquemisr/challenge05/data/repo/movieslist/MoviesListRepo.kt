package com.banquemisr.challenge05.data.repo.movieslist

import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.MovieEntity
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.UpcomingMovie
import kotlinx.coroutines.flow.Flow

interface MoviesListRepo {
    fun getNowPlayingMoviesList(): Flow<PagingData<NowPlayingMovie>>

    fun getPopularMoviesList(): Flow<PagingData<PopularMovie>>

    fun getUpcomingMoviesList(): Flow<PagingData<UpcomingMovie>>
}
