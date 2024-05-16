package com.example.koinapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.koinapp.KoinApp
import com.example.koinapp.presentation.home.HomeScreen
import com.example.koinapp.presentation.home.HomeScreenViewModel

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination =Screen.HomeScreen.route ) {

        composable(route=Screen.HomeScreen.route){
            val viewModel= viewModel<HomeScreenViewModel>(
                factory= viewModelFactoryHelper {
                    HomeScreenViewModel(KoinApp.appModule.koinRepository)
                }

            )

            HomeScreen(homeScreenViewModel = viewModel)
        }
        composable(Screen.SearchScreen.route){

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Search")
            }
        }
        composable(Screen.CoinScreen.route){

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Coins")
            }
        }
        composable(Screen.AccountScreen.route){

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Account")
            }
        }


    }

}

sealed class Screen(val route:String){
    data object HomeScreen:Screen("home_screen")
    data object SearchScreen:Screen("search_screen")
    data object CoinScreen:Screen("coin_screen")
    data object AccountScreen:Screen("account_screen")
}

fun <VM: ViewModel> viewModelFactoryHelper(initializer: () -> VM): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}