package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.core.Resource

interface DataSource {

    suspend fun getAllCharacter(page: Int): Resource<List<CharacterRemote>>
    suspend fun getCharactersFavorites() : Resource<List<Character>>
    suspend fun insertCharacterEntity(character: Character)
}