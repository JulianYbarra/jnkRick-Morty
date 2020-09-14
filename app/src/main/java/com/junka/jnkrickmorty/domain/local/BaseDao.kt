package com.junka.jnkrickmorty.domain.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg o: T)

    @Delete
    suspend fun delete(vararg o : T)

    @Update()
    suspend fun update(vararg  o: T)

}