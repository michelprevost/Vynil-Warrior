package com.jidarc.vynilwarrior.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jidarc.vynilwarrior.screens.SplashScreen

@Composable
fun VWNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = VWScreens.SplashScreen.name) {

        composable(VWScreens.SplashScreen.name) {
           SplashScreen(navController = navController)
        }

    }
}