package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterAndLocation
import com.junka.jnkrickmorty.data.model.CharacterWithEpisodes

@Dao
interface CharacterDao : BaseDao<Character> {

    @Query("SELECT * FROM Character")
    suspend fun getAll(): List<Character>


    @Transaction
    @Query("SELECT * FROM Character")
    fun getCharacterAndLocation(): List<CharacterAndLocation>

    @Transaction
    @Query("SELECT * FROM Character")
    fun getCharacterWithEpisodes(): List<CharacterWithEpisodes>


}