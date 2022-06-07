package com.jidarc.vynilwarrior.data.network

import com.jidarc.vynilwarrior.models.DiscogSearchResult
import com.jidarc.vynilwarrior.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DiscogsApi {

    @Headers("User-Agent: VynilWarriorClient/1.0")
    @GET(Constants.DISOCGS_SEARCH_URL)
    suspend fun searchDatabase(
        @Query("q") query: String,
        @Query("token") discogsToken: String
    ): Response<DiscogSearchResult>

}