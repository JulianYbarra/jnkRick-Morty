package com.junka.jnkrickmorty.data.model

import androidx.room.*

@Entity(
    primaryKeys = ["characterId", "episodeId"],
    indices = [Index(value = ["characterId", "episodeId"], unique = true)]
)
class CharacterEpisodeRef(
    val characterId: Long,
    val episodeId: Long
)

data class CharacterWithEpisodes(
    @Embedded val character: CharacterAndLocation,
    @Relation(
        parentColumn = "characterId",
        entity = Episode::class,
        entityColumn = "episodeId",
        associateBy = Junction(
            value = CharacterEpisodeRef::class,
            parentColumn = "characterId",
            entityColumn = "episodeId"
        )

    )
    val episodes: List<Episode>
)


data class EpisodeWithCharacters(
    @Embedded val episode: Episode,
    @Relation(
        parentColumn = "episodeId",
        entity = Character::class,
        entityColumn = "characterId",
        associateBy = Junction(
            value =CharacterEpisodeRef::class,
            parentColumn = "episodeId",
            entityColumn = "characterId"
        )
    )
    val characters: List<CharacterAndLocation>
)


data class EpisodeWithCharactersAndLocation(
    @Embedded val episode: Episode,
    @Relation(
        entity = Character::class,
        parentColumn = "episodeId",
        entityColumn = "characterId"
    )
    val characterAndLocation: List<CharacterAndLocation>
)
