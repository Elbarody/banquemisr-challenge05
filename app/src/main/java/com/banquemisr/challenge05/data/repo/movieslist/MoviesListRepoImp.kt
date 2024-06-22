package com.banquemisr.challenge05.data.repo.movieslist

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.NowPlayingMoviesDao
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.PopularMoviesDao
import com.banquemisr.challenge05.data.local.UpcomingMovie
import com.banquemisr.challenge05.data.local.UpcomingMoviesDao
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class MoviesListRepoImp(
    private val nowPlayingMoviesRemoteMediator: NowPlayingMoviesRemoteMediator,
    private val popularMoviesRemoteMediator: PopularMoviesRemoteMediator,
    private val upcomingMoviesRemoteMediator: UpcomingMoviesRemoteMediator,
    private val upcomingMoviesDao: UpcomingMoviesDao,
    private val nowPlayingMoviesDao: NowPlayingMoviesDao,
    private val popularMoviesDao: PopularMoviesDao,
) : MoviesListRepo {

    override fun getNowPlayingMoviesList(): Flow<PagingData<NowPlayingMovie>> {
        return Pager(config = PagingConfig(
            pageSize = 20, enablePlaceholders = false
        ),
            remoteMediator = nowPlayingMoviesRemoteMediator,
            pagingSourceFactory = { nowPlayingMoviesDao.getMoviesNowPlaying() }).flow
    }

    override fun getPopularMoviesList(): Flow<PagingData<PopularMovie>> {
        return Pager(config = PagingConfig(
            pageSize = 20, enablePlaceholders = false
        ),
            remoteMediator = popularMoviesRemoteMediator,
            pagingSourceFactory = { popularMoviesDao.getPopularMovies() }).flow
    }

    override fun getUpcomingMoviesList(): Flow<PagingData<UpcomingMovie>> {
        return Pager(config = PagingConfig(
            pageSize = 20, enablePlaceholders = false
        ),
            remoteMediator = upcomingMoviesRemoteMediator,
            pagingSourceFactory = { upcomingMoviesDao.getUpcomingMovies() }).flow
    }
}