package com.jidarc.vynilwarrior.data.repositories

import com.jidarc.vynilwarrior.data.network.DiscogsApi
import com.jidarc.vynilwarrior.models.artist.Artist
import com.jidarc.vynilwarrior.models.label.Label
import com.jidarc.vynilwarrior.models.master.Master
import com.jidarc.vynilwarrior.models.release.Release
import com.jidarc.vynilwarrior.models.searchresults.DiscogSearchResult
import com.jidarc.vynilwarrior.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class DiscogsRepository @Inject constructor(private val discogsApi: DiscogsApi) {

    suspend fun searchDatabase(searchQuery: String): Response<DiscogSearchResult> {
        return discogsApi.searchDatabase(searchQuery, Constants.DISCOGS_TOKEN)
    }

    suspend fun getArtist(id: String): Response<Artist> {
        return discogsApi.getArtist(id, Constants.DISCOGS_TOKEN)
    }

    suspend fun getMaster(id: String): Response<Master> {
        return discogsApi.getMaster(id, Constants.DISCOGS_TOKEN)
    }

    suspend fun getLabel(id: String): Response<Label> {
        return discogsApi.getLabel(id, Constants.DISCOGS_TOKEN)
    }

    suspend fun getRelease(id: String): Response<Release> {
        return discogsApi.getRelease(id, Constants.DISCOGS_TOKEN)
    }

}