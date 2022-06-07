package com.jidarc.vynilwarrior.screens.searchresults

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jidarc.vynilwarrior.data.repositories.DiscogRepository
import com.jidarc.vynilwarrior.models.Pagination
import com.jidarc.vynilwarrior.models.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultsViewModel @Inject constructor(private val repository: DiscogRepository) :
    ViewModel() {

    var resultsList = mutableStateListOf<Result>()
    var paginationInfo: MutableLiveData<Pagination?> = MutableLiveData<Pagination?>( null)

    fun searchDiscogs(query: String) {
        viewModelScope.launch {
            val searchResults = repository.searchDatabase(query)
            resultsList.clear()
            resultsList.addAll(searchResults.body()!!.results)
            paginationInfo.value = searchResults.body()!!.pagination

            Log.d("searchDiscogs", "Result: ${searchResults.body().toString()}")
        }
    }

}