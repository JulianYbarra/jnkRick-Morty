package com.junka.jnkrickmorty.domain.local

import androidx.room.*
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterAndLocation
import com.junka.jnkrickmorty.data.model.CharacterEpisodeRef
import com.junka.jnkrickmorty.data.model.CharacterWithEpisodes

@Dao
interface CharacterDao : BaseDao<Character> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterEpisodeRef(characterEpisodeRef: CharacterEpisodeRef)

    @Query("SELECT * FROM Character")
    suspend fun getAll(): List<Character>

    @Transaction
    @Query("SELECT * FROM Character")
    fun getCharacterAndLocation(): List<CharacterAndLocation>

    @Transaction
    @Query("SELECT * FROM Character WHERE characterId = :id LIMIT 1")
    fun getSingleCharacterAndLocation(id : Long): CharacterAndLocation

    @Transaction
    @Query("SELECT * FROM Character WHERE characterId = :id LIMIT 1")
    fun getSingleCharacterWithEpisodes(id : Long): CharacterWithEpisodes
}