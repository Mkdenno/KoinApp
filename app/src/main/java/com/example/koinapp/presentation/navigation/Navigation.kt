package com.example.koinapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.koinapp.presentation.home.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination =Screen.HomeScreen.route ) {

        composable(Screen.HomeScreen.route){
            HomeScreen()
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