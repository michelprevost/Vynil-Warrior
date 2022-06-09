package com.jidarc.vynilwarrior.models.release

import com.google.gson.annotations.SerializedName


data class Release(

    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("year")
    var year: Int? = null,
    @SerializedName("resource_url")
    var resourceUrl: String? = null,
    @SerializedName("uri")
    var uri: String? = null,
    @SerializedName("artists")
    var artists: ArrayList<Artist> = arrayListOf(),
    @SerializedName("artists_sort")
    var artistsSort: String? = null,
    @SerializedName("labels")
    var labels: ArrayList<Label> = arrayListOf(),
    @SerializedName("series")
    var series: ArrayList<String> = arrayListOf(),
    @SerializedName("companies")
    var companies: ArrayList<Company> = arrayListOf(),
    @SerializedName("formats")
    var formats: ArrayList<Format> = arrayListOf(),
    @SerializedName("data_quality")
    var dataQuality: String? = null,
    @SerializedName("community")
    var community: Community? = Community(),
    @SerializedName("format_quantity")
    var formatQuantity: Int? = null,
    @SerializedName("date_added")
    var dateAdded: String? = null,
    @SerializedName("date_changed")
    var dateChanged: String? = null,
    @SerializedName("num_for_sale")
    var numForSale: Int? = null,
    @SerializedName("lowest_price")
    var lowestPrice: Double? = null,
    @SerializedName("master_id")
    var masterId: Int? = null,
    @SerializedName("master_url")
    var masterUrl: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("country")
    var country: String? = null,
    @SerializedName("released")
    var released: String? = null,
    @SerializedName("notes")
    var notes: String? = null,
    @SerializedName("released_formatted")
    var releasedFormatted: String? = null,
    @SerializedName("identifiers")
    var identifiers: ArrayList<Identifier> = arrayListOf(),
    @SerializedName("videos")
    var videos: ArrayList<Video> = arrayListOf(),
    @SerializedName("genres")
    var genres: ArrayList<String> = arrayListOf(),
    @SerializedName("styles")
    var styles: ArrayList<String> = arrayListOf(),
    @SerializedName("tracklist")
    var tracklist: ArrayList<Tracklist> = arrayListOf(),
    @SerializedName("extraartists")
    var extraartists: ArrayList<ExtraArtist> = arrayListOf(),
    @SerializedName("images")
    var images: ArrayList<Image> = arrayListOf(),
    @SerializedName("thumb")
    var thumb: String? = null,
    @SerializedName("estimated_weight")
    var estimatedWeight: Int? = null,
    @SerializedName("blocked_from_sale")
    var blockedFromSale: Boolean? = null

)