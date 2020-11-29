package com.junka.jnkrickmorty.domain

import android.util.Log
import com.junka.jnkrickmorty.core.Helper
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.data.model.*
import javax.inject.Inject

class RepoImpl @Inject constructor(private val dataSource: DataSource) : Repo {

    override suspend fun getAllCharacters(page: Int): Resource<List<CharacterRemote>> {
        return dataSource.getAllCharacterRemote(page)
    }

    override suspend fun insert(character: Character) {
        dataSource.insertCharacter(character)
    }

    override suspend fun getAllEpisode(page: Int): Resource<List<Episode>> {

        val result = dataSource.getAllEpisodesRemote(page)
        when (result) {
            is Resource.Success -> {
                for (e in result.data) {

                    try {

                        val charactersInEpisode = Helper.getIdsFromUrl(e.characters).map {
                            CharacterEpisodeRef(it, e.id)
                        }

                        dataSource.insertEpisode(e.toEpisode())

                        charactersInEpisode.forEach {
                            dataSource.insertCharacterEpisodeRef(it)
                        }
                    } catch (e: Exception) {
                        Log.e("Ferror", "getAllEpisode: ${e.message}")
                    }
                }
            }
            is Resource.Failure -> {

            }
        }

        return dataSource.getAllEpisodeCached()
    }

}