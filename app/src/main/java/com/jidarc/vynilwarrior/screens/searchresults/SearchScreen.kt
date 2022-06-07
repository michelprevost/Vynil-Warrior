package com.jidarc.vynilwarrior.screens.searchresults

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.jidarc.vynilwarrior.R
import com.jidarc.vynilwarrior.components.InputField
import com.jidarc.vynilwarrior.components.VWAppBar
import com.jidarc.vynilwarrior.models.Result
import com.jidarc.vynilwarrior.navigation.VWScreens

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
fun SearchScreen(
    navController: NavController = NavController(LocalContext.current),
    searchResultsViewModel: SearchResultsViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        VWAppBar(
            title = "Search Discogs",
            navController = navController,
            icon = Icons.Default.ArrowBack,
            showProfile = false
        ) {
            navController.navigate(VWScreens.Home.name)
        }
    }) {
        Surface {
            Column {
                SearchForm(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) { searchQuery ->
                    searchResultsViewModel.searchDiscogs(query = searchQuery)
                }
                Spacer(modifier = Modifier.height(13.dp))
                ResultsList(navController = navController)
            }
        }
    }
}

@Composable
fun ResultsList(navController: NavController, viewModel: SearchResultsViewModel = hiltViewModel()) {

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
        items(items = viewModel.resultsList) { result ->
            ResultRow(result = result, navController = navController)
        }
    }
}

@Composable
fun ResultRow(result: Result, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .height(100.dp)
            .padding(3.dp)
            .clickable { /* TODO: go to details screen */ },
        shape = MaterialTheme.shapes.large,
        elevation = 7.dp
    ) {
        Row(modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.Top) {
            val imageUrl: String = result.coverImage

            Image(
                painter = if (imageUrl.isNotEmpty()) rememberImagePainter(data = imageUrl) else painterResource(
                    id = R.drawable.ic_vinyl_record
                ),
                contentDescription = "Cover image",
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .padding(end = 4.dp)
            )

            Column() {
                Text(
                    text = result.title,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = result.type,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchForm(
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    hint: String = "Search",
    onSearch: (String) -> Unit = {}
) {
    Column {
        val searchQueryState = rememberSaveable { mutableStateOf("") }
        val keyboardController = LocalSoftwareKeyboardController.current
        val valid = remember(searchQueryState.value) {
            searchQueryState.value.trim().isNotEmpty()
        }

        InputField(valueState = searchQueryState,
            labelId = "Search",
            enabled = true,
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyboardController?.hide()
            })

    }
}