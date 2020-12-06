package com.junka.jnkrickmorty.character.service

import com.junka.jnkrickmorty.data.model.AllCharactersResponse
import com.junka.jnkrickmorty.data.model.MultipleCharacterResponse
import com.junka.jnkrickmorty.data.model.SingleCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character/")
    suspend fun getAllCharacter(@Query("page") page: Int): AllCharactersResponse

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Long): SingleCharacterResponse

    @GET("character/{ids}")
    suspend fun getMultipleCharacters(@Path("id") ids: List<Long>): MultipleCharacterResponse
}