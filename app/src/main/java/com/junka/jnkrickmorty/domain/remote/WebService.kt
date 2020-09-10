package com.junka.jnkrickmorty.domain.remote

import com.junka.jnkrickmorty.data.model.CharacterResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("character/")
    suspend fun getAllCharacter(@Query("page") page : Int) : CharacterResponse
}