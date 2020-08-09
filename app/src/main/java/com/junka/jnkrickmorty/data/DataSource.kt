package com.junka.jnkrickmorty.data

import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.vo.Resource
import com.junka.jnkrickmorty.vo.RetrofitClient

class DataSource {

    suspend fun getAllCharacter(page: Int): Resource<List<Character>> {
        return Resource.Success(RetrofitClient.webService.getAllCharacter(page).results)
    }
}