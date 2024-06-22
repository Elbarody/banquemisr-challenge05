package com.banquemisr.challenge05.data.repo.movieslist

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.banquemisr.challenge05.data.local.MoviesDatabase
import com.banquemisr.challenge05.data.local.UpcomingMovie
import com.banquemisr.challenge05.data.mappers.toMovieNowPlayingEntity
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class UpcomingMoviesRemoteMediator(
    private val remoteDataSource: MoviesListRemoteDataSource, private val movieDb: MoviesDatabase
) : RemoteMediator<Int, UpcomingMovie>() {

    private var nextPageNumber = 1 
    private var totalPages: Int? = null

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UpcomingMovie>
    ): MediatorResult {
        try {
            val pageToLoad = when (loadType) {
                LoadType.REFRESH -> {
                    nextPageNumber = 1
                    1
                }

                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    if (nextPageNumber > (totalPages ?: Int.MAX_VALUE)) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    nextPageNumber
                }
            }

            val response = remoteDataSource.getMoviesList(
                page = pageToLoad,
                moviesType = "upcoming"
            )
            val movies = response.moviesList
            totalPages = response.totalPages

            movieDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    movieDb.nowPlayingMoviesDao().clearAllNowPlayingMovies()
                }
                val movieEntities = movies.map { it.toMovieNowPlayingEntity() }
                movieDb.nowPlayingMoviesDao().insertAllNowPlayingMovies(movieEntities)
            }
            nextPageNumber++

            return MediatorResult.Success(endOfPaginationReached = movies.isEmpty())
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }
}

