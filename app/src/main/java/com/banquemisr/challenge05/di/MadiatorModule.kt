package com.banquemisr.challenge05.di

import com.banquemisr.challenge05.data.remote.mediator.NowPlayingMoviesRemoteMediator
import com.banquemisr.challenge05.data.remote.mediator.PopularMoviesRemoteMediator
import com.banquemisr.challenge05.data.remote.mediator.UpcomingMoviesRemoteMediator
import org.koin.dsl.module

val mediatorModule = module {
    single<NowPlayingMoviesRemoteMediator> { NowPlayingMoviesRemoteMediator(get(), get()) }
    single<PopularMoviesRemoteMediator> { PopularMoviesRemoteMediator(get(), get()) }
    single<UpcomingMoviesRemoteMediator> { UpcomingMoviesRemoteMediator(get(), get()) }
}