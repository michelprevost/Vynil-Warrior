package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName

data class Company(

    @SerializedName("name")
    var name: String? = null,
    @SerializedName("catno")
    var catno: String? = null,
    @SerializedName("entity_type")
    var entityType: String? = null,
    @SerializedName("entity_type_name")
    var entityTypeName: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("thumbnail_url")
    var thumbnailUrl: String? = null

)