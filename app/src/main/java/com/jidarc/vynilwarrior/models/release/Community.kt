package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Community(

    @SerializedName("have")
    var have: Int? = null,
    @SerializedName("want")
    var want: Int? = null,
    @SerializedName("rating")
    var rating: Rating? = Rating(),
    @SerializedName("submitter")
    var submitter: Submitter? = Submitter(),
    @SerializedName("contributors")
    var contributors: ArrayList<Contributor> = arrayListOf(),
    @SerializedName("data_quality")
    var dataQuality: String? = null,
    @SerializedName("status")
    var status: String? = null

)