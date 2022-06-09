package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Artist(

    @SerializedName("name")
    var name: String? = null,
    @SerializedName("anv")
    var anv: String? = null,
    @SerializedName("join")
    var join: String? = null,
    @SerializedName("role")
    var role: String? = null,
    @SerializedName("tracks")
    var tracks: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String? = null

)