package com.banquemisr.challenge05.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface PopularMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPopularMovies(movies: List<PopularMovie>)

    @Query("Select * From popular_movies")
    fun getPopularMovies(): PagingSource<Int, PopularMovie>

    @Query("Delete From popular_movies")
    suspend fun clearPopularMovies()
}