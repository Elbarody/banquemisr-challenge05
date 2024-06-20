package com.banquemisr.challenge05.di

import com.banquemisr.challenge05.data.remote.moviedetails.MovieDetailsApi
import com.banquemisr.challenge05.data.remote.moviedetails.MovieDetailsRemoteDataSource
import com.banquemisr.challenge05.data.remote.moviedetails.MovieDetailsRemoteDataSourceImp
import com.banquemisr.challenge05.data.repo.moviedetails.MovieDetailsRepo
import com.banquemisr.challenge05.data.repo.moviedetails.MovieDetailsRepoImp
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val movieDetailsModule = module {
    single { get<Retrofit>().create(MovieDetailsApi::class.java) }
    single<MovieDetailsRemoteDataSource> { MovieDetailsRemoteDataSourceImp(get()) }
    single<MovieDetailsRepo> { MovieDetailsRepoImp(get()) }
}