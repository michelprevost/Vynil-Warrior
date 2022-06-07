package com.jidarc.vynilwarrior.screens.searchresults

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.jidarc.vynilwarrior.ui.theme.VynilWarriorTheme

@Preview(showBackground = true)
@Composable
fun SearchResultsScreen(
    navController: NavController = NavController(LocalContext.current),
    searchQuery: String = "Queen",
    searchResultsViewModel: SearchResultsViewModel = hiltViewModel()
) {
    searchResultsViewModel.searchDiscogs(searchQuery)

    VynilWarriorTheme {
        LazyColumn {
            items(searchResultsViewModel.resultsList) { item ->
                Text(text = item.title)
            }
        }
    }
}