package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Episode(
    @PrimaryKey()
    val id: Int,
    val name: String = "",
    val airDate: String = "",
    val episode: String = "",
    val url: String = "",
    val created: String
) : Parcelable


data class EpisodeRemote(
    val id: Int,
    val name: String = "",
    @SerializedName("air_date")
    val airDate: String = "",
    val episode: String = "",
    val characters: List<String> = listOf(),
    val url: String = "",
    val created: String
)

data class AllEpisodesResponse(
    val info: Info,
    val results: List<EpisodeRemote>
)

data class SingleEpisodesResponse(
    val result: EpisodeRemote
)

data class MultipleEpisodesResponse(
    val results: List<EpisodeRemote>
)

