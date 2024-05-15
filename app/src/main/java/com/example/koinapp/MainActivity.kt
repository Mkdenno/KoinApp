package com.example.koinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.koinapp.presentation.components.BottomNav
import com.example.koinapp.presentation.home.HomeScreen
import com.example.koinapp.presentation.navigation.Navigation
import com.example.koinapp.presentation.navigation.Screen
import com.example.koinapp.ui.theme.KoinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}

@Composable
fun MainScreen(){
    val navController= rememberNavController()
    KoinAppTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            bottomBar = {
                BottomNav (
                    navController = navController,
                    onItemsSelected={navItem->
                        navController.navigate(navItem.route){
                            launchSingleTop=true
                            popUpTo(Screen.HomeScreen.route){
                                inclusive=false
                                saveState=false
                            }
                            restoreState=true
                        }
                    }
                )
            }

        ) {paddingValue->


            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValue),
                color = MaterialTheme.colorScheme.background
            ) {
                Navigation(navController = navController )
            }
        }
    }
}

@Preview(
    showBackground = true,
    heightDp=500,
    widthDp=350
)
@Composable
fun HomeScreenPreview(){
    KoinAppTheme{
        MainScreen()
    }
}