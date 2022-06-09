package com.jidarc.vynilwarrior.models.label

import com.google.gson.annotations.SerializedName

data class Label(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("releases_url")
    var releasesUrl: String? = null,
    @SerializedName("images")
    var images: ArrayList<Image> = arrayListOf(),
    @SerializedName("contact_info")
    var contactInfo: String? = null,
    @SerializedName("profile")
    var profile: String? = null,
    @SerializedName("data_quality")
    var dataQuality: String? = null,
    @SerializedName("urls")
    var urls: ArrayList<String> = arrayListOf(),
    @SerializedName("sublabels")
    var sublabels: ArrayList<Sublabel> = arrayListOf()

)