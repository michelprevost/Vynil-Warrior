package com.jidarc.vynilwarrior.models.master

import com.google.gson.annotations.SerializedName

data class Master(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("main_release")
    var mainRelease: Int? = null,
    @SerializedName("most_recent_release")
    var mostRecentRelease: Int? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("versions_url")
    var versionsUrl: String? = null,
    @SerializedName("main_release_url")
    var mainReleaseUrl: String? = null,
    @SerializedName("most_recent_release_url")
    var mostRecentReleaseUrl: String? = null,
    @SerializedName("num_for_sale")
    var numForSale: Int? = null,
    @SerializedName("lowest_price")
    var lowestPrice: Int? = null,
    @SerializedName("images")
    var images: ArrayList<Image> = arrayListOf(),
    @SerializedName("genres")
    var genres: ArrayList<String> = arrayListOf(),
    @SerializedName("styles")
    var styles: ArrayList<String> = arrayListOf(),
    @SerializedName("year")
    var year: Int? = null,
    @SerializedName("tracklist")
    var tracklist: ArrayList<Tracklist> = arrayListOf(),
    @SerializedName("artists")
    var artists: ArrayList<Artist> = arrayListOf(),
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("notes")
    var notes: String? = null,
    @SerializedName("data_quality")
    var dataQuality: String? = null,
    @SerializedName("videos")
    var videos: ArrayList<Videos> = arrayListOf()

)