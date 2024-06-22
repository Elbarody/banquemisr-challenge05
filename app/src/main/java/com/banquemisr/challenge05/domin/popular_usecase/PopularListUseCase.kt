package com.banquemisr.challenge05.domin.popular_usecase

import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.PopularMovie
import kotlinx.coroutines.flow.Flow

interface PopularListUseCase {

    fun getPopularMoviesList(): Flow<PagingData<PopularMovie>>
}