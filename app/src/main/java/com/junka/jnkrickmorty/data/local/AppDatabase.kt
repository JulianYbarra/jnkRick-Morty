package com.junka.jnkrickmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.domain.local.CharacterDao

@Database(entities = [CharacterEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}