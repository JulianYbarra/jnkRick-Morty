package com.junka.jnkrickmorty.data.model

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Character(
    @PrimaryKey()
    @ColumnInfo(name = "characterId")
    val id: Long = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    @Embedded
    val origin: Origin? = null,
    val locationId: Long,
    val image: String = "",
    val url: String = "",
    val created: String = ""
) : Parcelable


@DatabaseView
data class CharacterAndLocation(
    @Embedded val character: Character,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "locationId",
        entity = Location::class
    )
    val location: Location
)

@Parcelize
data class CharacterRemote(
    val id: Long = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: OriginRemote? = null,
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