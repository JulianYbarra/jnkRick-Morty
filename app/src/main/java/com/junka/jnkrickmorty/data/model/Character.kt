package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: Origin? = null,
    val location: Location? = null,
    val image: String = "",
    val episode: List<String>? = null,
    val url: String = "",
    val created: String = ""
) : Parcelable


data class CharacterResponse(
    @SerializedName("info")
    val info : Info,
    @SerializedName("results")
    val results : List<Character>
)

@Entity
data class CharacterEntity(
    @PrimaryKey()
    val id: Int,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    //val origin: Origin? = null,
    //val location: Location? = null,
    val image: String = "",
    //val episode: List<String>? = null,
    val url: String = "",
    val created: String = ""
)