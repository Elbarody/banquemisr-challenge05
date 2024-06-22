package com.banquemisr.challenge05.data.repo.movieslist

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.RemoteMediator
import com.banquemisr.challenge05.data.local.MovieEntity
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.UpcomingMovie
import kotlinx.coroutines.flow.Flow

interface MoviesListRepo {

    @OptIn(ExperimentalPagingApi::class)
    fun <T : Any> createPagerForMovies(
        remoteMediator: RemoteMediator<Int, T>,
        pagingSourceFactory: () -> PagingSource<Int, T>
    ): Flow<PagingData<T>>
}
