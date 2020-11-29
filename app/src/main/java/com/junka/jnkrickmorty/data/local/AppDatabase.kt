package com.junka.jnkrickmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.data.model.CharacterEpisodeRef
import com.junka.jnkrickmorty.data.model.Episode
import com.junka.jnkrickmorty.data.model.Location
import com.junka.jnkrickmorty.domain.local.CharacterDao
import com.junka.jnkrickmorty.domain.local.EpisodeDao
import com.junka.jnkrickmorty.domain.local.LocationDao

@Database(
    entities = [Character::class, CharacterEpisodeRef::class, Episode::class, Location::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
}