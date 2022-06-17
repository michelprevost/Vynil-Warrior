package com.jidarc.vynilwarrior.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jidarc.vynilwarrior.screens.SplashScreen
import com.jidarc.vynilwarrior.screens.details.DetailsScreen
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

        composable(
            route = "${VWScreens.Details.name}/{type}/{id}",
            arguments = listOf(
                navArgument("type") {
                    type = NavType.StringType
                },
                navArgument("id") {
                    type = NavType.StringType
                })
        ) { entry ->
            entry.arguments?.let {
                val type = entry.arguments?.getString("type")!!
                val id = entry.arguments?.getString("id")!!
                DetailsScreen(type, id, navController = navController)
            }
        }

    }
}