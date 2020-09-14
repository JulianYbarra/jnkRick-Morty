package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.model.*

interface DataSource {

    //Remote
    suspend fun getAllCharacterRemote(page: Int): Resource<List<CharacterRemote>>
    suspend fun getSingleCharacterRemote(id: Long): Resource<CharacterRemote>
    suspend fun getMultipleCharacterRemote(ids: List<Long>): Resource<List<CharacterRemote>>

    suspend fun getAllEpisodesRemote(page: Int): Resource<List<EpisodeRemote>>
    suspend fun getSingleEpisodeRemote(id: Long): Resource<EpisodeRemote>
    suspend fun getMultipleEpisodeRemote(ids: List<Long>): Resource<List<EpisodeRemote>>

    suspend fun getAllLocationRemote(page: Int): Resource<List<LocationRemote>>
    suspend fun getSingleLocationRemote(id: Long): Resource<LocationRemote>
    suspend fun getMultipleLocationRemote(ids: List<Long>): Resource<List<LocationRemote>>

    //Local
    suspend fun insertCharacter(character: Character)

    suspend fun getAllCharacterCached(page: Int): Resource<List<CharacterAndLocation>>
    suspend fun getSingleCharacterCached(id: Long): Resource<CharacterAndLocation>
    suspend fun getMultipleCharacterCached(ids: List<Long>): Resource<List<CharacterAndLocation>>

    suspend fun getCharacterWithEpisodes(id : Long) : Resource<CharacterWithEpisodes>

    suspend fun insertEpisode(episode: Episode)

    suspend fun getAllEpisodeCached(): Resource<List<Episode>>
    suspend fun getSingleEpisodeCached(id: Long): Resource<Episode>
    suspend fun getMultipleEpisodeCached(ids: List<Long>): Resource<List<Episode>>

    suspend fun getEpisodeWithCharacters(id : Long) : Resource<EpisodeWithCharactersAndLocation>

    suspend fun insertLocation(location: Location)

    suspend fun getAllLocationCached(): Resource<List<Location>>
    suspend fun getSingleLocationCached(id: Long): Resource<Location>
    suspend fun getMultipleLocationCached(ids: List<Long>): Resource<List<Location>>




}