package com.jidarc.vynilwarrior.screens.searchresults

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jidarc.vynilwarrior.data.repositories.DiscogsRepository
import com.jidarc.vynilwarrior.models.searchresults.Result
import com.jidarc.vynilwarrior.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel @Inject constructor(private val repository: DiscogsRepository) :
    ViewModel() {

    var searchResponse: MutableState<NetworkResult<List<Result>>> =
        mutableStateOf(NetworkResult.Loading())

    fun searchDiscogs(query: String) {
        searchResponse.value = NetworkResult.Loading()
        viewModelScope.launch {
            try {
                val response = repository.searchDatabase(query)
                when {
                    response.message().toString().contains("timeout") -> {
                        searchResponse.value = NetworkResult.Error("Timeout")
                    }
                    response.body()!!.results.isEmpty() -> {
                        searchResponse.value =
                            NetworkResult.Error("Search Query $query returned no result")
                    }
                    response.isSuccessful -> {
                        searchResponse.value = NetworkResult.Success(response.body()!!.results)
                    }
                    else -> {
                        searchResponse.value = NetworkResult.Error(response.message())
                    }
                }
            } catch (e: Exception) {
                searchResponse.value = NetworkResult.Error("Recipes not found: ${e.message}")
            }
        }
    }
}
