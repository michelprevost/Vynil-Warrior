package com.jidarc.vynilwarrior.models.artist

import com.google.gson.annotations.SerializedName

data class Image(

    @SerializedName("type")
    var type: String? = null,
    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("uri150")
    var uri150: String? = null,
    @SerializedName("width")
    var width: Int? = null,
    @SerializedName("height")
    var height: Int? = null

)