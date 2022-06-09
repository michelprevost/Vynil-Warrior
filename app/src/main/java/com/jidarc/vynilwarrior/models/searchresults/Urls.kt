package com.jidarc.vynilwarrior.models.searchresults


import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("last")
    val last: String,
    @SerializedName("next")
    val next: String
)