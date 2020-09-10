package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.domain.local.CharacterDao
import com.junka.jnkrickmorty.domain.remote.WebService
import com.junka.jnkrickmorty.core.Resource
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val characterDao: CharacterDao, private val webService: WebService) : DataSource {

    override suspend fun getAllCharacter(page: Int): Resource<List<CharacterRemote>> {
        return Resource.Success(webService.getAllCharacter(page).results)
    }

    override suspend fun getCharactersFavorites() : Resource<List<Character>> {
        return Resource.Success(characterDao.getAll())
    }

   override suspend fun insertCharacterEntity(character: Character){
       characterDao.insert(character)
   }
}