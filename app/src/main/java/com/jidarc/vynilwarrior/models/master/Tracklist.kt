package com.jidarc.vynilwarrior.models.master

import com.google.gson.annotations.SerializedName


data class Tracklist(

    @SerializedName("position")
    var position: String? = null,
    @SerializedName("type_")
    var type_: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("extraartists")
    var extraartists: ArrayList<ExtraArtist> = arrayListOf(),
    @SerializedName("duration")
    var duration: String? = null

)