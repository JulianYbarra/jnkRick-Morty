package com.junka.jnkrickmorty.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity(primaryKeys = ["characterId", "episodeId"])
class CharacterEpisodeRef(
    val characterId: Int,
    val episodeId: Int
)

data class CharacterWithEpisodes(
    @Embedded val character: Character,
    @Relation(
        parentColumn = "characterId",
        entityColumn = "episodeId"
        //associateBy = @Junction(value = CharacterEpisodeRef::class)
    )
    val episodes: List<Episode>
)

data class EpisodeWithCharacters(
    @Embedded val episode: Episode,
    @Relation(
        parentColumn = "songId",
        entityColumn = "playlistId"
        //associateBy = @Junction(PlaylistSongCrossRef::class)
    )
    val characters: List<Character>
)
