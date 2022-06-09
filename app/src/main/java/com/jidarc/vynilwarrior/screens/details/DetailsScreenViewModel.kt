package com.jidarc.vynilwarrior.screens.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jidarc.vynilwarrior.data.repositories.DiscogsRepository
import com.jidarc.vynilwarrior.models.artist.Artist
import com.jidarc.vynilwarrior.models.label.Label
import com.jidarc.vynilwarrior.models.master.Master
import com.jidarc.vynilwarrior.models.release.Release
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(private val repository: DiscogsRepository) :
    ViewModel() {

    var artist = mutableStateOf(Artist())
    var master = mutableStateOf(Master())
    var label = mutableStateOf(Label())
    var release = mutableStateOf(Release())

    fun getArtist(id: String) {
        viewModelScope.launch {
            artist.value = repository.getArtist(id).body()!!
        }
    }

    fun getMaster(id: String) {
        viewModelScope.launch {
            master.value = repository.getMaster(id).body()!!
        }
    }

    fun getLabel(id: String) {
        viewModelScope.launch {
            artist.value = repository.getArtist(id).body()!!
        }
    }

    fun getRelease(id: String) {
        viewModelScope.launch {
            artist.value = repository.getArtist(id).body()!!
        }
    }
}