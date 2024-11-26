package com.fastlink.zekir_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fastlink.zekir_app.ui.favoriteScreen.FavoriteScreen
import com.fastlink.zekir_app.ui.homeScreen.HomeScreen
import com.fastlink.zekir_app.ui.zekirScreen.ZekirScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController ,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Favorite.route) {
            FavoriteScreen(navController = navController)
        }
        composable("${Screen.ZekirScreen.route}/{categoryId}") {
            ZekirScreen(
                navController = navController,
            )
        }
    }
}
