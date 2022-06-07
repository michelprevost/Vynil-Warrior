package com.jidarc.vynilwarrior.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.jidarc.vynilwarrior.SearchBar
import com.jidarc.vynilwarrior.ui.theme.VynilWarriorTheme

@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController = NavController(LocalContext.current)) {
    VynilWarriorTheme {
        SearchBar()
    }
}