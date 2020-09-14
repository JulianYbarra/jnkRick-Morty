package com.junka.jnkrickmorty.domain.local

import androidx.room.Dao
import com.junka.jnkrickmorty.data.model.Location

@Dao
interface LocationDao : BaseDao<Location> {

}