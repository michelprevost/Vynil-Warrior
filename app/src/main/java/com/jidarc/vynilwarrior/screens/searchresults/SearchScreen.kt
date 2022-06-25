package com.jidarc.vynilwarrior.screens.searchresults

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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
import com.jidarc.vynilwarrior.components.ShimmeringRow
import com.jidarc.vynilwarrior.components.VWAppBar
import com.jidarc.vynilwarrior.models.searchresults.Result
import com.jidarc.vynilwarrior.navigation.VWScreens
import com.jidarc.vynilwarrior.utils.NetworkResult

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchScreen(
    navController: NavController = NavController(LocalContext.current),
    searchResultsViewModel: SearchResultsViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        VWAppBar(
            title = "Search Discogs",
            icon = Icons.Default.ArrowBack,
            showProfile = false
        ) {
            navController.navigate(VWScreens.Home.name)
        }
    }) { paddingValues ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(paddingValues)
            ) {
                val searchCalled = remember { mutableStateOf(false) }
                SearchForm(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) { searchQuery ->
                    searchResultsViewModel.searchDiscogs(query = searchQuery)
                    searchCalled.value = true
                }
                Spacer(modifier = Modifier.height(13.dp))
                ResultsList(searchCalled = searchCalled.value) { type, id ->
                    navController.navigate("${VWScreens.Details.name}/$type/$id")
                }
            }
        }
    }
}

@Composable
fun ResultsList(
    modifier: Modifier = Modifier,
    searchCalled: Boolean = false,
    viewModel: SearchResultsViewModel = hiltViewModel(),
    onRowClick: (String, Int) -> Unit = { _, _ -> }
) {
    val errorMessage = viewModel.searchResponse.value.message
    val searchResultList = viewModel.searchResponse.value.data

    if (viewModel.searchResponse.value is NetworkResult.Loading && searchCalled) {
        Column(modifier = modifier.padding(16.dp)) {
            ShimmeringRow(modifier)
            ShimmeringRow(modifier)
            ShimmeringRow(modifier)
        }
    } else if (viewModel.searchResponse.value is NetworkResult.Error) {
        SearchErrorMessage(modifier, errorMessage!!)
    } else if (viewModel.searchResponse.value is NetworkResult.Success && searchResultList != null) {
        LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
            items(items = searchResultList) { result ->
                ResultRow(result = result, onRowClick = onRowClick)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultRow(result: Result, onRowClick: (String, Int) -> Unit = { _, _ -> }) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(3.dp)
            .clickable { onRowClick(result.type, result.id) },
        shape = MaterialTheme.shapes.large
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
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = result.type,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleSmall
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

@Composable
fun SearchErrorMessage(modifier: Modifier = Modifier, message: String) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.error)
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            color = contentColorFor(backgroundColor = MaterialTheme.colorScheme.error)
        )
    }
}