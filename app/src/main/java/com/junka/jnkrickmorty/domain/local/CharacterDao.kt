package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.junka.jnkrickmorty.data.model.CharacterEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM CharacterEntity")
    suspend fun getAll() : List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterEntity: CharacterEntity)
}