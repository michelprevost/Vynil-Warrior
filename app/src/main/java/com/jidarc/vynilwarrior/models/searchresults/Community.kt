package com.jidarc.vynilwarrior.models.searchresults


import com.google.gson.annotations.SerializedName

data class Community(
    @SerializedName("have")
    val have: Int,
    @SerializedName("want")
    val want: Int
)