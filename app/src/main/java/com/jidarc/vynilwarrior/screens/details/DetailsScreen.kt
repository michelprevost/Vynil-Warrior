package com.jidarc.vynilwarrior.screens.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jidarc.vynilwarrior.components.VWAppBar
import com.jidarc.vynilwarrior.screens.details.subscreens.ArtistInfo
import com.jidarc.vynilwarrior.screens.details.subscreens.LabelInfo
import com.jidarc.vynilwarrior.screens.details.subscreens.MasterInfo
import com.jidarc.vynilwarrior.screens.details.subscreens.ReleaseInfo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    type: String,
    id: String,
    navController: NavController,
    viewModel: DetailsScreenViewModel = hiltViewModel()
) {
    val title = type.capitalize(locale = Locale.current)

    Scaffold(topBar = {
        VWAppBar(
            title = title,
            icon = Icons.Default.ArrowBack,
            showProfile = false
        ) {
            navController.popBackStack()
        }
    }) { paddingValues ->
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            when (type) {
                "artist" -> {
                    viewModel.getArtist(id)
                    ArtistInfo(artist = viewModel.artist.value)
                }
                "master" -> {
                    viewModel.getMaster(id)
                    MasterInfo(master = viewModel.master.value)
                }
                "label" -> {
                    viewModel.getLabel(id)
                    LabelInfo(label = viewModel.label.value)
                }
                "release" -> {
                    viewModel.getRelease(id)
                    ReleaseInfo(release = viewModel.release.value)
                }
            }
        }
    }
}