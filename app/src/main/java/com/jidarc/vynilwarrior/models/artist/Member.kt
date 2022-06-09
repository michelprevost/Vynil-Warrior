package com.jidarc.vynilwarrior.models.artist

import com.google.gson.annotations.SerializedName

data class Member(

    @SerializedName("active")
    var active: Boolean? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("uri")
    var name: String? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String? = null

)
