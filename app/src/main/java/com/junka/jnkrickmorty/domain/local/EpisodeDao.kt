package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.junka.jnkrickmorty.data.model.Episode
import com.junka.jnkrickmorty.data.model.EpisodeWithCharacters
import com.junka.jnkrickmorty.data.model.EpisodeWithCharactersAndLocation

@Dao
interface EpisodeDao : BaseDao<Episode> {

    @Query("SELECT * FROM Episode")
    suspend fun getAllEpisode() : List<Episode>

    @Query("SELECT * FROM Episode WHERE episodeId = :id LIMIT 1")
    suspend fun getSingleEpisode(id : Long) : Episode

    @Transaction
    @Query("SELECT * FROM Episode")
    suspend fun getEpisodeWithCharacters(): List<EpisodeWithCharacters>

    @Transaction
    @Query("SELECT * FROM Episode WHERE episodeId = :id")
    suspend fun getEpisodeWithCharactersAndLocation(id: Long): EpisodeWithCharactersAndLocation

    @Transaction
    @Query("SELECT * FROM Episode")
    suspend fun getEpisodesWithCharacters(): List<EpisodeWithCharactersAndLocation>

}

