package com.jidarc.vynilwarrior.models


import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("last")
    val last: String,
    @SerializedName("next")
    val next: String
)