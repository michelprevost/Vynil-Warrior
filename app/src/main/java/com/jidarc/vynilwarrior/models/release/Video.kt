package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Video(

    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("duration")
    var duration: Int? = null,
    @SerializedName("embed")
    var embed: Boolean? = null

)