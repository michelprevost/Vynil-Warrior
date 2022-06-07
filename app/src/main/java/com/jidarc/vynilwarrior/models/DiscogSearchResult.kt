package com.jidarc.vynilwarrior.models


import com.google.gson.annotations.SerializedName

data class DiscogSearchResult(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("results")
    val results: List<Result>
)