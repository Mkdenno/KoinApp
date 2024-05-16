package com.example.koinapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.koinapp.data.Repository.KoinRepository
import com.example.koinapp.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
   private val koinRepository: KoinRepository
):ViewModel(){

    private val _state= MutableStateFlow(HomeState())
    val state=_state.asStateFlow()


    init {
        getCoins()
    }

    fun getCoins()=viewModelScope.launch {
        koinRepository.getKoinList().collect(){result->

            when(result){

                is Resource.Error->{
                    _state.value= HomeState(
                        isLoading = false
                    )
                }
                is Resource.Loading->{
                    _state.value= HomeState(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    Log.i("*********",result.data.toString())
                    _state.value= HomeState(
                        isLoading = false,
                        data = result.data
                    )
                }
            }

        }

    }

}
