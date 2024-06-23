package com.banquemisr.challenge05

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import com.banquemisr.challenge05.data.local.NowPlayingMovie
import com.banquemisr.challenge05.data.local.PopularMovie
import com.banquemisr.challenge05.data.local.UpcomingMovie
import com.banquemisr.challenge05.domin.nowdisplay_usecase.NowPlayUseCase
import com.banquemisr.challenge05.domin.popular_usecase.PopularListUseCase
import com.banquemisr.challenge05.domin.upcoming_usecase.UpcomingListUseCase
import com.banquemisr.challenge05.presenter.movieslist.MoviesListViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var nowPlayingUseCase: NowPlayUseCase

    @Mock
    private lateinit var upcomingUseCase: UpcomingListUseCase

    @Mock
    private lateinit var popularUseCase: PopularListUseCase

    private lateinit var viewModel: MoviesListViewModel

    @Before
    fun setup() {

        viewModel = MoviesListViewModel(nowPlayingUseCase, upcomingUseCase, popularUseCase)
    }

    @Test
    fun `test get now playing movies`() = runBlocking {

        val mockPagingData =
            PagingData.from(listOf(NowPlayingMovie(1, "Movie 1", "", "Overview 1")))
        `when`(nowPlayingUseCase.getNowPlayingMoviesList()).thenReturn(flowOf(mockPagingData))

        val actualFlow = viewModel.moviesNowPlayFlow

        assertEquals(mockPagingData, actualFlow.first())
    }

    @Test
    fun `test get popular movies`() = runBlocking {
        val mockPagingData = PagingData.from(listOf(PopularMovie(2, "Movie 2", "", "Overview 2")))
        `when`(popularUseCase.getPopularMoviesList()).thenReturn(flowOf(mockPagingData))

        val actualFlow = viewModel.moviesPopularFlow

        assertEquals(mockPagingData, actualFlow.first())
    }

    @Test
    fun `test get upcoming movies`() = runBlocking {
        val mockPagingData = PagingData.from(listOf(UpcomingMovie(3, "Movie 3", "", "Overview 3")))
        `when`(upcomingUseCase.getUpcomingMoviesList()).thenReturn(flowOf(mockPagingData))

        val actualFlow = viewModel.moviesUpcomingFlow

        assertEquals(mockPagingData, actualFlow.first())
    }
}