package com.example.koinapp.data.Repository

import android.util.Log
import com.example.koinapp.data.data.KoinRankingApi
import com.example.koinapp.data.model.Coin
import com.example.koinapp.data.model.Data
import com.example.koinapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

interface KoinRepository {
    fun getKoinList(): Flow<Resource<List<Coin>>>
}

class KoinRepositoryImpl(
    private val api: KoinRankingApi
):KoinRepository {
    override fun getKoinList(): Flow<Resource<List<Coin>>>  = flow{
        try {
            emit(Resource.Loading())
            val result=api.getCoins().data.coins
            emit(Resource.Success(result))
        }
        catch (e:HttpException){
            Log.i("*****", e.message.toString())
            emit(Resource.Error("Server Error"))
        }
        catch (e:IOException){
            emit(Resource.Error("Network Error"))
        }
        catch (e:RuntimeException){
            emit(Resource.Error("Run time Error"))
        }
    }
}