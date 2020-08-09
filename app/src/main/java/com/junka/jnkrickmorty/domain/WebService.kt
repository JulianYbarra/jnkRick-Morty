package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.model.CharacterResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("character/?page=")
    suspend fun getAllCharacter(@Query("count") count : Int) : CharacterResponse
}