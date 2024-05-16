package com.example.koinapp.data.data

import com.example.koinapp.data.model.KoinResponse
import retrofit2.http.GET

interface KoinRankingApi {

    @GET("coins")
    suspend fun getCoins():KoinResponse
}