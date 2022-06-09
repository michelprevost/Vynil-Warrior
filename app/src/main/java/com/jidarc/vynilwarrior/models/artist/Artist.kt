package com.jidarc.vynilwarrior.models.artist

import com.google.gson.annotations.SerializedName

data class Artist(

    @SerializedName("name")
    var name: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("releases_url")
    var releasesUrl: String? = null,
    @SerializedName("images")
    var images: ArrayList<Image> = arrayListOf(),
    @SerializedName("realname")
    var realname: String? = null,
    @SerializedName("profile")
    var profile: String? = null,
    @SerializedName("urls")
    var urls: ArrayList<String> = arrayListOf(),
    @SerializedName("aliases")
    var aliases: ArrayList<Alias> = arrayListOf(),
    @SerializedName("data_quality")
    var dataQuality: String? = null,
    @SerializedName("namevariations")
    var nameVariations: ArrayList<String> = arrayListOf(),
    @SerializedName("members")
    var members: ArrayList<Member> = arrayListOf()

)