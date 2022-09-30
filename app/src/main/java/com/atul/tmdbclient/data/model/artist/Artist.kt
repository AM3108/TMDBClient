package com.atul.tmdbclient.data.model.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artist")
data class Artist(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("known_for_department")
    val knownForDepartment: String?,

    @ColumnInfo(name = "artist_name")
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)