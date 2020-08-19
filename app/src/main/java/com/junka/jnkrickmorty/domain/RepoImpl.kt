package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.vo.Resource
import javax.inject.Inject

class RepoImpl @Inject constructor(private val dataSource: DataSource) : Repo {

    override suspend fun getAllCharacters(page : Int): Resource<List<Character>> {
        return dataSource.getAllCharacter(page)
    }

    override suspend fun insert(characterEntity: CharacterEntity) {
        dataSource.insertCharacterEntity(characterEntity)
    }

    override suspend fun getCharactersFavorites(): Resource<List<CharacterEntity>> {
       return dataSource.getCharactersFavorites()
    }
}