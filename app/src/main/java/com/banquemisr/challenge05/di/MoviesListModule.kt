package com.banquemisr.challenge05.di

import MoviesListRepoImp
import com.banquemisr.challenge05.data.remote.movieList.MoviesListApi
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSource
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSourceImp
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import com.banquemisr.challenge05.domin.nowdisplay_usecase.NowPlayUseCase
import com.banquemisr.challenge05.domin.nowdisplay_usecase.NowPlayUseCaseImp
import com.banquemisr.challenge05.domin.popular_usecase.PopularListUseCase
import com.banquemisr.challenge05.domin.popular_usecase.PopularListUseCaseImp
import com.banquemisr.challenge05.domin.upcoming_usecase.UpcomingListUseCase
import com.banquemisr.challenge05.domin.upcoming_usecase.UpcomingListUseCaseImp
import com.banquemisr.challenge05.presenter.movieslist.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val moviesListModule = module {
    single { get<Retrofit>().create(MoviesListApi::class.java) }
    single<MoviesListRemoteDataSource> { MoviesListRemoteDataSourceImp(get()) }
    single<MoviesListRepo> { MoviesListRepoImp() }
    single<NowPlayUseCase> { NowPlayUseCaseImp(get(), get(), get()) }
    single<PopularListUseCase> { PopularListUseCaseImp(get(), get(), get()) }
    single<UpcomingListUseCase> { UpcomingListUseCaseImp(get(), get(), get()) }
    viewModel { MoviesListViewModel(get(), get(), get()) }
}