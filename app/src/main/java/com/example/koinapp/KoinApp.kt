package com.example.koinapp

import android.app.Application
import com.example.koinapp.di.AppModule
import com.example.koinapp.di.AppModuleImpl

class KoinApp: Application() {

    companion object{
        lateinit var appModule: AppModule

    }

    override fun onCreate() {
        super.onCreate()

        appModule=AppModuleImpl()
    }

}