package com.junka.jnkrickmorty

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.domain.CharacterDao

@Database(entities = [CharacterEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}