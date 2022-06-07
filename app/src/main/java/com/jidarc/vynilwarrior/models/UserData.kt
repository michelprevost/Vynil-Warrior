package com.jidarc.vynilwarrior.models


import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("in_collection")
    val inCollection: Boolean,
    @SerializedName("in_wantlist")
    val inWantlist: Boolean
)