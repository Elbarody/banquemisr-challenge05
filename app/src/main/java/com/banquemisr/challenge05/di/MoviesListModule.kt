package com.banquemisr.challenge05.di

import com.banquemisr.challenge05.data.remote.movieList.MoviesListApi
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSource
import com.banquemisr.challenge05.data.remote.movieList.MoviesListRemoteDataSourceImp
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepo
import com.banquemisr.challenge05.data.repo.movieslist.MoviesListRepoImp
import com.banquemisr.challenge05.presenter.movieslist.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val moviesListModule = module {
    single { get<Retrofit>().create(MoviesListApi::class.java) }
    single<MoviesListRemoteDataSource> { MoviesListRemoteDataSourceImp(get()) }
    single<MoviesListRepo> { MoviesListRepoImp(get()) }
    viewModel { MoviesListViewModel(get()) }
}