package com.jidarc.vynilwarrior.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController = NavController(LocalContext.current)) {
    Text("Hello World!")
}