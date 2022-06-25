package com.jidarc.vynilwarrior.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.jidarc.vynilwarrior.navigation.VWScreens
import com.jidarc.vynilwarrior.ui.theme.VynilWarriorTheme

@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController = NavController(LocalContext.current)) {
    VynilWarriorTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = { navController.navigate(VWScreens.Search.name) }) {
                    Text(text = "Search Discogs")
                }
            }
        }
    }
}