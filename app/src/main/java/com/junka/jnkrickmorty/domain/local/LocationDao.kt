package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import androidx.room.Query
import com.junka.jnkrickmorty.data.model.Location

@Dao
interface LocationDao : BaseDao<Location> {

    @Query("SELECT * FROM location")
    suspend fun getAllLocation() : List<Location>

    @Query("SELECT * FROM location WHERE locationId = :id LIMIT 1")
    suspend fun getSingleLocation(id : Long) : Location


}