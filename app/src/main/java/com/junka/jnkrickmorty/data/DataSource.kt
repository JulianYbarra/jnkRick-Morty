package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.core.Resource

interface DataSource {

    suspend fun getAllCharacter(page: Int): Resource<List<Character>>
    suspend fun getCharactersFavorites() : Resource<List<CharacterEntity>>
    suspend fun insertCharacterEntity(characterEntity: CharacterEntity)
}