package com.junka.jnkrickmorty.character.repository

import com.junka.jnkrickmorty.character.service.CharacterService
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.domain.local.CharacterDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterService : CharacterService,
    private val characterDao : CharacterDao) {

    fun getCharacters(page : Int) : Flow<List<CharacterRemote>> = flow {
        emit(characterService.getAllCharacter(page).results)
    }
}