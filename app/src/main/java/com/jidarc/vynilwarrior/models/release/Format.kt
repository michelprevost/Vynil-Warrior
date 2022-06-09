package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Format(

    @SerializedName("name")
    var name: String? = null,
    @SerializedName("qty")
    var qty: String? = null,
    @SerializedName("descriptions")
    var descriptions: ArrayList<String> = arrayListOf()

)