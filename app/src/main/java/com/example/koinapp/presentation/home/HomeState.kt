package com.example.koinapp.presentation.home

import com.example.koinapp.data.model.Coin
import com.example.koinapp.data.model.Data
import com.example.koinapp.data.model.KoinResponse

class HomeState (
    val isLoading:Boolean=false,
//    val data:List<Coin>?=null,
    val data: List<Coin> = emptyList(),
    val errorMessage:String=""
)