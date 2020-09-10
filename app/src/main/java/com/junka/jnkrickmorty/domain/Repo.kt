package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.core.Resource

interface Repo {
    suspend fun getAllCharacters(page : Int) : Resource<List<CharacterRemote>>

    suspend fun insert(character: Character)
    suspend fun getCharactersFavorites() : Resource<List<Character>>
}