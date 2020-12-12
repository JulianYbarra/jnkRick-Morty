package com.junka.jnkrickmorty.episodes.service

import com.junka.jnkrickmorty.data.model.AllEpisodesResponse
import com.junka.jnkrickmorty.data.model.MultipleEpisodesResponse
import com.junka.jnkrickmorty.data.model.SingleEpisodesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeService {

    @GET("episode/")
    suspend fun getAllEpisode(@Query("page") page: Int): AllEpisodesResponse

    @GET("episode/{id}")
    suspend fun getSingleEpisode(@Path("id") id: Long): SingleEpisodesResponse

    @GET("episode/{ids}")
    suspend fun getMultipleEpisode(@Path("id") ids: List<Long>): MultipleEpisodesResponse
}