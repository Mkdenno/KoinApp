package com.example.koinapp.di

import okhttp3.Interceptor
import okhttp3.Response

class Intercepter:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request().newBuilder().apply {
            addHeader("x-access-token", "coinranking8022e0d1fcf70b0c77699d4284ff83a5f1cfdf39b31a7275")

        }
            .build()
       return chain.proceed(request)
    }
}