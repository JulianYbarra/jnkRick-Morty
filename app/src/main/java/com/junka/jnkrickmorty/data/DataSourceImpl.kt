package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.AppDatabase
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.domain.CharacterDao
import com.junka.jnkrickmorty.domain.WebService
import com.junka.jnkrickmorty.vo.Resource
import com.junka.jnkrickmorty.vo.RetrofitClient
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private val characterDao: CharacterDao, private val webService: WebService) : DataSource {

    override suspend fun getAllCharacter(page: Int): Resource<List<Character>> {
        return Resource.Success(webService.getAllCharacter(page).results)
    }

    override suspend fun getCharactersFavorites() : Resource<List<CharacterEntity>>{
        return Resource.Success(characterDao.getAll())
    }

   override suspend fun insertCharacterEntity(characterEntity: CharacterEntity){
       characterDao.insert(characterEntity)
   }
}