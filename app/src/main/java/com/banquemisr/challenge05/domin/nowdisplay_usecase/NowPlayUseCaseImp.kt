package com.banquemisr.challenge05.domin.nowdisplay_usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.NowPlayingMoviesDao
import com.banquemisr.challenge05.data.remote.mediator.NowPlayingMoviesRemoteMediator
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import kotlinx.coroutines.flow.Flow

class NowPlayUseCaseImp(
    private val moviesListRepo: MoviesListRepo,
    private val nowPlayingMoviesRemoteMediator: NowPlayingMoviesRemoteMediator,
    private val nowPlayingMoviesDao: NowPlayingMoviesDao
) : NowPlayUseCase {
    @OptIn(ExperimentalPagingApi::class)
    override fun getNowPlayingMoviesList(): Flow<PagingData<NowPlayingMovie>> =
        moviesListRepo.createPagerForMovies(nowPlayingMoviesRemoteMediator) {
            nowPlayingMoviesDao.getMoviesNowPlaying()
        }
}