package com.jidarc.vynilwarrior.screens.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
            navController = navController,
            icon = Icons.Default.ArrowBack,
            showProfile = false
        ) {
            navController.popBackStack()
        }
    }) {
        Surface(modifier = Modifier.fillMaxSize()) {
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