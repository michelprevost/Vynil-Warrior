package com.jidarc.vynilwarrior.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jidarc.vynilwarrior.screens.SplashScreen
import com.jidarc.vynilwarrior.screens.home.HomeScreen
import com.jidarc.vynilwarrior.screens.searchresults.SearchScreen

@Composable
fun VWNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = VWScreens.Splash.name) {

        composable(route = VWScreens.Splash.name) {
            SplashScreen(navController = navController)
        }

        composable(route = VWScreens.Home.name) {
            HomeScreen(navController = navController)
        }

        composable(route = VWScreens.Search.name) {
            SearchScreen(navController = navController)
        }

    }
}