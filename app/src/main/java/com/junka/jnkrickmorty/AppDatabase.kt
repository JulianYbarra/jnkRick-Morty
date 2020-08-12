package com.junka.jnkrickmorty

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.domain.CharacterDao

@Database(entities = [CharacterEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE =
                INSTANCE ?: Room.databaseBuilder(context, AppDatabase::class.java, "jnk_rm_database")
                    .build()

            return INSTANCE!!
        }
    }
}