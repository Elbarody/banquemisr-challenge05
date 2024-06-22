package com.banquemisr.challenge05.domin.nowdisplay_usecase

import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import kotlinx.coroutines.flow.Flow

interface NowPlayUseCase {
    fun getNowPlayingMoviesList(): Flow<PagingData<NowPlayingMovie>>

}