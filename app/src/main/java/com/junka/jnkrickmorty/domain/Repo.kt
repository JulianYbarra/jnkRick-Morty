package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.model.Episode

interface Repo {

    suspend fun getAllEpisode(page : Int) : Resource<List<Episode>>

    suspend fun getAllCharacters(page : Int) : Resource<List<CharacterRemote>>
    suspend fun insert(character: Character)
}