package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.local.AppDatabase
import com.junka.jnkrickmorty.data.model.*
import com.junka.jnkrickmorty.domain.remote.WebService
import javax.inject.Inject

class DataSourceImpl @Inject constructor(
    private val appDatabase: AppDatabase,
    private val webService: WebService
) : DataSource {

    override suspend fun getAllCharacterRemote(page: Int): Resource<List<CharacterRemote>> {
        return Resource.Success(webService.getAllCharacter(page).results)
    }

    override suspend fun getSingleCharacterRemote(id: Long): Resource<CharacterRemote> {
        return Resource.Success(webService.getSingleCharacter(id).result)
    }

    override suspend fun getMultipleCharacterRemote(ids: List<Long>): Resource<List<CharacterRemote>> {
        return Resource.Success(webService.getMultipleCharacters(ids).results)
    }

    override suspend fun getAllEpisodesRemote(page: Int): Resource<List<EpisodeRemote>> {
        return Resource.Success(webService.getAllEpisode(page).results)
    }

    override suspend fun getSingleEpisodeRemote(id: Long): Resource<EpisodeRemote> {
        return Resource.Success(webService.getSingleEpisode(id).result)
    }

    override suspend fun getMultipleEpisodeRemote(ids: List<Long>): Resource<List<EpisodeRemote>> {
        return Resource.Success(webService.getMultipleEpisode(ids).results)
    }

    override suspend fun getAllLocationRemote(page: Int): Resource<List<LocationRemote>> {
        return Resource.Success(webService.getAllLocation(page).results)
    }

    override suspend fun getSingleLocationRemote(id: Long): Resource<LocationRemote> {
        return Resource.Success(webService.getSingleLocation(id).result)
    }

    override suspend fun getMultipleLocationRemote(ids: List<Long>): Resource<List<LocationRemote>> {
        return Resource.Success(webService.getMultipleLocation(ids).results)
    }

    override suspend fun insertCharacter(character: Character) {
        appDatabase.characterDao().insert(character)
    }

    override suspend fun insertCharacterEpisodeRef(characterEpisodeRef: CharacterEpisodeRef) {
        appDatabase.characterDao().insertCharacterEpisodeRef(characterEpisodeRef)
    }

    override suspend fun getAllCharacterCached(page: Int): Resource<List<CharacterAndLocation>> {
        return Resource.Success(appDatabase.characterDao().getCharacterAndLocation())
    }

    override suspend fun getSingleCharacterCached(id: Long): Resource<CharacterAndLocation> {
        return Resource.Success(appDatabase.characterDao().getSingleCharacterAndLocation(id))
    }

    override suspend fun getMultipleCharacterCached(ids: List<Long>): Resource<List<CharacterAndLocation>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterWithEpisodes(id: Long): Resource<CharacterWithEpisodes> {
        return Resource.Success(appDatabase.characterDao().getSingleCharacterWithEpisodes(id))
    }

    override suspend fun insertEpisode(episode: Episode) {
        appDatabase.episodeDao().insert(episode)
    }

    override suspend fun getAllEpisodeCached(): Resource<List<Episode>> {
        return Resource.Success(appDatabase.episodeDao().getAllEpisode())
    }

    override suspend fun getSingleEpisodeCached(id: Long): Resource<Episode> {
        return Resource.Success(appDatabase.episodeDao().getSingleEpisode(id))
    }

    override suspend fun getMultipleEpisodeCached(ids: List<Long>): Resource<List<Episode>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodeWithCharacters(id: Long): Resource<EpisodeWithCharactersAndLocation> {
        return Resource.Success(appDatabase.episodeDao().getEpisodeWithCharactersAndLocation(id))
    }

    override suspend fun insertLocation(location: Location) {
        appDatabase.locationDao().insert(location)
    }

    override suspend fun getAllLocationCached(): Resource<List<Location>> {
        return Resource.Success(appDatabase.locationDao().getAllLocation())
    }

    override suspend fun getSingleLocationCached(id: Long): Resource<Location> {
        return Resource.Success(appDatabase.locationDao().getSingleLocation(id))
    }

    override suspend fun getMultipleLocationCached(ids: List<Long>): Resource<List<Location>> {
        TODO("Not yet implemented")
    }
}