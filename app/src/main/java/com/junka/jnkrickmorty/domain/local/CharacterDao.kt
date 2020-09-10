package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.junka.jnkrickmorty.data.model.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM Character")
    suspend fun getAll() : List<Character>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: Character)
}