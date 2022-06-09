package com.jidarc.vynilwarrior.data.network

import com.jidarc.vynilwarrior.models.artist.Artist
import com.jidarc.vynilwarrior.models.label.Label
import com.jidarc.vynilwarrior.models.master.Master
import com.jidarc.vynilwarrior.models.release.Release
import com.jidarc.vynilwarrior.models.searchresults.DiscogSearchResult
import com.jidarc.vynilwarrior.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DiscogsApi {

    @Headers("User-Agent: VynilWarriorClient/1.0")
    @GET(Constants.DISOCGS_SEARCH_URL)
    suspend fun searchDatabase(
        @Query("q") query: String,
        @Query("token") discogsToken: String
    ): Response<DiscogSearchResult>

    @Headers("User-Agent: VynilWarriorClient/1.0")
    @GET(Constants.DISOCGS_GET_ARTIST)
    suspend fun getArtist(
        @Path("id") id: String,
        @Query("token") discogsToken: String
    ): Response<Artist>

    @Headers("User-Agent: VynilWarriorClient/1.0")
    @GET(Constants.DISOCGS_GET_MASTER)
    suspend fun getMaster(
        @Query("id") query: String,
        @Query("token") discogsToken: String
    ): Response<Master>

    @Headers("User-Agent: VynilWarriorClient/1.0")
    @GET(Constants.DISOCGS_GET_LABEL)
    suspend fun getLabel(
        @Query("id") query: String,
        @Query("token") discogsToken: String
    ): Response<Label>

    @Headers("User-Agent: VynilWarriorClient/1.0")
    @GET(Constants.DISOCGS_GET_RELEASE)
    suspend fun getRelease(
        @Query("id") query: String,
        @Query("token") discogsToken: String
    ): Response<Release>

}