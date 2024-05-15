package com.example.koinapp.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CurrencyBitcoin
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.CurrencyExchange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.koinapp.presentation.navigation.Screen

@Composable
fun BottomNav(
    navController: NavController,
    onItemsSelected:(NavItem)->Unit
) {
    val backstackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backstackEntry?.destination

    val mutableInteraction = remember { MutableInteractionSource() }

    Box(modifier = Modifier
        .fillMaxWidth()
    ){
        Row(
            modifier = Modifier .padding(16.dp)

        ) {

        navItems.forEach { navItem ->
            val selected=navItem.route == currentDestination?.route
            val iconColor by animateColorAsState(
                targetValue = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(1f),
                label = "Icon Color",
                animationSpec = tween(
                    easing= EaseInOut
                )
                )
            
            val iconScale by animateFloatAsState(
                targetValue =if (selected) 1f else .9f,
                label = "Icon Scale",
                animationSpec = spring(
                    visibilityThreshold = .000001f,
                    stiffness = Spring.StiffnessLow,
                    dampingRatio = Spring.DampingRatioMediumBouncy
                )
            )
            Box (
                modifier = Modifier
                    .weight(1f / navItems.size)
                    .clickable {
                        onItemsSelected(navItem)
                    },
                contentAlignment = Alignment.Center
            ){

                Icon(
                    imageVector =if (selected) navItem.selectedIcon else navItem.unselectedIcon ,
                    contentDescription =null,
                    tint = iconColor,
                    modifier = Modifier
                        .size(30.dp)
                        .scale(iconScale)
                )

            }

        }
    }}


}
val navItems= listOf(
    NavItem(
        route = Screen.HomeScreen.route,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    NavItem(
        route = Screen.SearchScreen.route,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search
    ),

    NavItem(
        route = Screen.CoinScreen.route,
        selectedIcon = Icons.Filled.CurrencyExchange,
        unselectedIcon = Icons.Outlined.CurrencyExchange
    ),

    NavItem(
        route = Screen.AccountScreen.route,
        selectedIcon = Icons.Filled.AccountCircle,
        unselectedIcon = Icons.Outlined.AccountCircle
    ),
)

data class NavItem(
    val route:String,
    val selectedIcon: ImageVector,
    val unselectedIcon:ImageVector
)


