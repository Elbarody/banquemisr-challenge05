package com.banquemisr.challenge05.domin.upcoming_usecase

import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.UpcomingMovie
import kotlinx.coroutines.flow.Flow

interface UpcomingListUseCase {

    fun getUpcomingMoviesList(): Flow<PagingData<UpcomingMovie>>
}