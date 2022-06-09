package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Contributor(

    @SerializedName("username")
    var username: String? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null

)