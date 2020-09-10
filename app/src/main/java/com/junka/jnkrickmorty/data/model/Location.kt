package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    @PrimaryKey()
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String,
    val created: String
) : Parcelable

data class LocationRemote(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String
)

data class AllLocationResponse(
    val info: Info,
    val results: List<LocationRemote>
)

data class SingleLocationResponse(
    val result: LocationRemote
)

data class MultipleLocationResponse(
    val results: List<LocationRemote>
)
