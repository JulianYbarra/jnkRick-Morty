package com.junka.jnkrickmorty.vo

import com.google.gson.GsonBuilder
import com.junka.jnkrickmorty.domain.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val baseUrl = "https://rickandmortyapi.com/api/"

    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}