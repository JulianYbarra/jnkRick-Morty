package com.junka.jnkrickmorty.character.controller

import com.junka.jnkrickmorty.character.repository.CharacterRepository
import com.junka.jnkrickmorty.data.model.CharacterRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterController @Inject constructor(
    private val characterRepository: CharacterRepository) {

    fun getCharacters(page : Int) : Flow<List<CharacterRemote>> = characterRepository.getCharacters(page)


}