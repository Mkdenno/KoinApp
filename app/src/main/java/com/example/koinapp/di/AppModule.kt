package com.example.koinapp.di

import com.example.koinapp.data.Repository.KoinRepository
import com.example.koinapp.data.Repository.KoinRepositoryImpl
import com.example.koinapp.data.data.KoinRankingApi
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule {
    val api:KoinRankingApi
    val koinRepository: KoinRepository
    val intercepter:OkHttpClient
}


class AppModuleImpl():AppModule {
    override val api: KoinRankingApi by lazy {
     Retrofit.Builder()
         .baseUrl("https://api.coinranking.com/v2/")
         .client(intercepter)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create()
    }

    override val koinRepository: KoinRepository by lazy {
        KoinRepositoryImpl(api)
    }
    override val intercepter: OkHttpClient by lazy {
       val intercepter=Intercepter()
        OkHttpClient.Builder().addInterceptor(intercepter).build()
    }
}