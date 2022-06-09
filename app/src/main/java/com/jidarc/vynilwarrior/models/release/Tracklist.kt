package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Tracklist(

    @SerializedName("position")
    var position: String? = null,
    @SerializedName("type_")
    var type_: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("duration")
    var duration: String? = null

)