package com.jidarc.vynilwarrior.screens.details.subscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.jidarc.vynilwarrior.models.artist.Artist

@Composable
fun ArtistInfo(
    artist: Artist,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val imageUrl = artist.images.first { it.type == "primary" }.uri
            Image(painter = rememberImagePainter(data = imageUrl), contentDescription = artist.name)
            Text(text = artist.name!!)
        }
    }
}