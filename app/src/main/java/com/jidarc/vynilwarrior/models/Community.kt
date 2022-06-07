package com.jidarc.vynilwarrior.models


import com.google.gson.annotations.SerializedName

data class Community(
    @SerializedName("have")
    val have: Int,
    @SerializedName("want")
    val want: Int
)