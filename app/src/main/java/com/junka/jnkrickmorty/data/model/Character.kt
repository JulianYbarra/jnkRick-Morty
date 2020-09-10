package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.android.parcel.Parcelize

@Entity
data class Character(
    @PrimaryKey()
    val id: Int,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    @Embedded
    val origin: Origin? = null,
    val location: Int,
    val image: String = "",
    val url: String = "",
    val created: String = ""
)

data class CharacterAndLocation(
    @Embedded val character: Character,
    @Relation(
        parentColumn = "location",
        entityColumn = "id"
    )
    val location: Location? = null
)

@Parcelize
data class CharacterRemote(
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

data class AllCharactersResponse(
    val info: Info,
    val results: List<CharacterRemote>
)

data class SingleCharacterResponse(
    val result : CharacterRemote
)

data class MultipleCharacterResponse(
    val results : List<CharacterRemote>
)

