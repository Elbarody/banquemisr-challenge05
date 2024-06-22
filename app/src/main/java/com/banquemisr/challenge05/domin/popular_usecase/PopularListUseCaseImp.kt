package com.banquemisr.challenge05.domin.popular_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.PopularMoviesDao
import com.banquemisr.challenge05.data.remote.mediator.PopularMoviesRemoteMediator
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.Flow

class PopularListUseCaseImp(
    private val moviesListRepo: MoviesListRepo,
    private val popularMoviesRemoteMediator: PopularMoviesRemoteMediator,
    private val popularMoviesDao: PopularMoviesDao,
) : PopularListUseCase {
    @OptIn(ExperimentalPagingApi::class)
    override fun getPopularMoviesList(): Flow<PagingData<PopularMovie>> =
        moviesListRepo.createPagerForMovies(popularMoviesRemoteMediator) {
            popularMoviesDao.getPopularMovies()
        }
}