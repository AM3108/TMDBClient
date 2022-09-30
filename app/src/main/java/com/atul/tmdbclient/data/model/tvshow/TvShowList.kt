package com.atul.tmdbclient.data.model.tvshow
import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val tvShow: List<TvShow>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)