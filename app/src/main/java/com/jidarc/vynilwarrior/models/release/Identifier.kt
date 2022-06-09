package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Identifier(

    @SerializedName("type")
    var type: String? = null,
    @SerializedName("value")
    var value: String? = null

)