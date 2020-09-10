package com.junka.jnkrickmorty.domain.remote

import com.junka.jnkrickmorty.data.model.*

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebService {

    @GET("character/")
    suspend fun getAllCharacter(@Query("page") page: Int): AllCharactersResponse

    @GET("character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Int): SingleCharacterResponse

    @GET("character/{ids}")
    suspend fun getMultipleCharacters(@Path("id") ids: List<Int>): MultipleCharacterResponse


    @GET("location/")
    suspend fun getAllLocation(@Query("page") page: Int): AllLocationResponse

    @GET("location/{id}")
    suspend fun getSingleLocation(@Path("id") id: Int): SingleLocationResponse

    @GET("location/{ids}")
    suspend fun getMultipleLocation(@Path("id") ids: List<Int>): MultipleLocationResponse


    @GET("episode/")
    suspend fun getAllEpisode(@Query("page") page: Int): AllEpisodesResponse

    @GET("episode/{id}")
    suspend fun getSingleEpisode(@Path("id") id: Int): SingleEpisodesResponse

    @GET("episode/{ids}")
    suspend fun getMultipleEpisode(@Path("id") ids: List<Int>): MultipleEpisodesResponse

}