package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.AppDatabase
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.vo.Resource
import com.junka.jnkrickmorty.vo.RetrofitClient

class DataSource(private val database: AppDatabase) {

    suspend fun getAllCharacter(page: Int): Resource<List<Character>> {
        return Resource.Success(RetrofitClient.webService.getAllCharacter(page).results)
    }

    suspend fun getCharactersFavorites() : Resource<List<CharacterEntity>>{
        return Resource.Success(database.characterDao().getAll())
    }

   suspend fun insertCharacterEntity(characterEntity: CharacterEntity){
       database.characterDao().insert(characterEntity)
   }
}