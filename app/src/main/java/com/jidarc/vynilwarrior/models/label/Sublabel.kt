package com.jidarc.vynilwarrior.models.label

import com.google.gson.annotations.SerializedName

data class Sublabel(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null

)