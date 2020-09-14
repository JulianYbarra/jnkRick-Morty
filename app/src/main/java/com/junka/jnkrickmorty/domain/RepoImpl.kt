package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.core.Resource
import javax.inject.Inject

class RepoImpl @Inject constructor(private val dataSource: DataSource) : Repo {

    override suspend fun getAllCharacters(page : Int): Resource<List<CharacterRemote>> {
        return dataSource.getAllCharacterRemote(page)
    }

    override suspend fun insert(character: Character) {
        dataSource.insertCharacter(character)
    }

}