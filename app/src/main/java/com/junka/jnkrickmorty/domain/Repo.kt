package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.vo.Resource

interface Repo {
    suspend fun getAllCharacters(page : Int) : Resource<List<Character>>

    suspend fun insert(characterEntity: CharacterEntity)
    suspend fun getCharactersFavorites() : Resource<List<CharacterEntity>>
}