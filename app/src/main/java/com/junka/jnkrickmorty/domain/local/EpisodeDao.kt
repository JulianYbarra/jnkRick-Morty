package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.junka.jnkrickmorty.data.model.Episode
import com.junka.jnkrickmorty.data.model.EpisodeWithCharacters
import com.junka.jnkrickmorty.data.model.EpisodeWithCharactersAndLocation

@Dao
interface EpisodeDao : BaseDao<Episode> {

    @Transaction
    @Query("SELECT * FROM Episode")
    fun getEpisodeWithCharacters(): List<EpisodeWithCharacters>


    @Transaction
    @Query("SELECT * FROM Episode WHERE episodeId = :id")
    fun getEpisodeWithCharacters(id: Long): EpisodeWithCharactersAndLocation

    @Transaction
    @Query("SELECT * FROM Episode")
    fun getEpisodesWithCharacters(): List<EpisodeWithCharactersAndLocation>

}

