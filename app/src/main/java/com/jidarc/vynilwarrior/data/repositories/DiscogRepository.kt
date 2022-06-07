package com.jidarc.vynilwarrior.data.repositories

import com.jidarc.vynilwarrior.data.network.DiscogsApi
import com.jidarc.vynilwarrior.models.DiscogSearchResult
import com.jidarc.vynilwarrior.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class DiscogRepository @Inject constructor(private val discogsApi: DiscogsApi) {

    suspend fun searchDatabase(searchQuery: String): Response<DiscogSearchResult> {
        return discogsApi.searchDatabase(searchQuery, Constants.DISCOGS_TOKEN)
    }

}