package com.banquemisr.challenge05.data.repo.movieslist

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.banquemisr.challenge05.data.local.MoviesDatabase
import com.banquemisr.challenge05.data.local.UpcomingMovie
import com.banquemisr.challenge05.data.mappers.toUpcomingMovieEntity
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class UpcomingMoviesRemoteMediator(
    private val remoteDataSource: MoviesListRemoteDataSource, private val movieDb: MoviesDatabase
) : RemoteMediator<Int, UpcomingMovie>() {

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, UpcomingMovie>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val movies = remoteDataSource.getMoviesList(
                page = loadKey,
                moviesType = "now_playing"
            ).moviesList

            movieDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    movieDb.upcomingMoviesDao().clearUpcomingMovies()
                }
                val movieEntities = movies.map { it.toUpcomingMovieEntity() }
                movieDb.upcomingMoviesDao().insertAllUpcomingMovies(movieEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = movies.isEmpty()
            )
        } catch (error: IOException) {
            return MediatorResult.Error(error)
        } catch (error: HttpException) {
            return MediatorResult.Error(error)
        }
    }
}

