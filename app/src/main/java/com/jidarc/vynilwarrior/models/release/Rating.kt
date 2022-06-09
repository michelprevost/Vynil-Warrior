package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Rating(

    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("average")
    var average: Double? = null

)