package com.banquemisr.challenge05.data.repo.movieslist.nowdisplay

import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import kotlinx.coroutines.flow.Flow

interface NowDisplayRepo {
    fun getNowPlayingMoviesList(): Flow<PagingData<NowPlayingMovie>>

}