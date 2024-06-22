package com.banquemisr.challenge05.domin.upcoming_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.UpcomingMovie
import com.banquemisr.challenge05.data.local.UpcomingMoviesDao
import com.banquemisr.challenge05.data.remote.mediator.UpcomingMoviesRemoteMediator
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.Flow

class UpcomingListUseCaseImp(
    private val moviesListRepo: MoviesListRepo,
    private val upcomingMoviesRemoteMediator: UpcomingMoviesRemoteMediator,
    private val upcomingMoviesDao: UpcomingMoviesDao
) : UpcomingListUseCase {
    @OptIn(ExperimentalPagingApi::class)
    override fun getUpcomingMoviesList(): Flow<PagingData<UpcomingMovie>> =
        moviesListRepo.createPagerForMovies(upcomingMoviesRemoteMediator) {
            upcomingMoviesDao.getUpcomingMovies()
        }
}