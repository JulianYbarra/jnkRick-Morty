package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Episode(
    @PrimaryKey()
    @ColumnInfo(name = "episodeId")
    val id: Long = 0,
    val name: String = "",
    val airDate: String = "",
    val episode: String = "",
    val url: String = "",
    val created: String = ""
) : Parcelable


data class EpisodeRemote(
    val id: Long,
    val name: String = "",
    @SerializedName("air_date")
    val airDate: String = "",
    val episode: String = "",
    val characters: List<String> = listOf(),
    val url: String = "",
    val created: String = ""
)

fun EpisodeRemote.toEpisode() : Episode{
    return Episode(id,name,airDate,episode, url,created)
}

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

