package com.banquemisr.challenge05.di

import com.google.gson.GsonBuilder
import com.banquemisr.challenge05.utility.network.interceptor.HeadersInterceptor
import com.banquemisr.challenge05.utility.network.interceptor.MockInterceptor
import com.banquemisr.challenge05.utility.network.RemoteConstants
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteModule = module{
    single { HeadersInterceptor() }
    single { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }
    single {
        val builder = OkHttpClient.Builder()
        val protocols = mutableListOf<Protocol>()
        protocols.add(Protocol.HTTP_1_1)
        builder.addInterceptor(get<HeadersInterceptor>())
            .connectTimeout(RemoteConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(RemoteConstants.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(RemoteConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .protocols(protocols)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(MockInterceptor())
            builder.addNetworkInterceptor(get<HttpLoggingInterceptor>())
        }
        builder.build()
    }

    single { GsonBuilder().create() }

    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl(RemoteConstants.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }

}