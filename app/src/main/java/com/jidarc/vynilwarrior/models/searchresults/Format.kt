package com.jidarc.vynilwarrior.models.searchresults


import com.google.gson.annotations.SerializedName

data class Format(
    @SerializedName("descriptions")
    val descriptions: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("qty")
    val qty: String,
    @SerializedName("text")
    val text: String
)