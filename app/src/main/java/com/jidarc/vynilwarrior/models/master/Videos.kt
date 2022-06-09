package com.jidarc.vynilwarrior.models.master

import com.google.gson.annotations.SerializedName


data class Videos (

  @SerializedName("uri"         ) var uri         : String?  = null,
  @SerializedName("title"       ) var title       : String?  = null,
  @SerializedName("description" ) var description : String?  = null,
  @SerializedName("duration"    ) var duration    : Int?     = null,
  @SerializedName("embed"       ) var embed       : Boolean? = null

)