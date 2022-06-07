package com.jidarc.vynilwarrior.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("barcode")
    val barcode: List<String>,
    @SerializedName("catno")
    val catno: String,
    @SerializedName("community")
    val community: Community,
    @SerializedName("country")
    val country: String,
    @SerializedName("cover_image")
    val coverImage: String,
    @SerializedName("format")
    val format: List<String>,
    @SerializedName("format_quantity")
    val formatQuantity: Int,
    @SerializedName("formats")
    val formats: List<Format>,
    @SerializedName("genre")
    val genre: List<String>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("label")
    val label: List<String>,
    @SerializedName("master_id")
    val masterId: Any,
    @SerializedName("master_url")
    val masterUrl: Any,
    @SerializedName("resource_url")
    val resourceUrl: String,
    @SerializedName("style")
    val style: List<String>,
    @SerializedName("thumb")
    val thumb: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("uri")
    val uri: String,
    @SerializedName("user_data")
    val userData: UserData,
    @SerializedName("year")
    val year: String
)