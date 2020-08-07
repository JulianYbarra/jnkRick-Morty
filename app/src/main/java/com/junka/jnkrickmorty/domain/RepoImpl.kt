package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.vo.Resource

class RepoImpl(private val dataSource: DataSource) : Repo {

    override fun getAllCharacters(): Resource<List<Character>> {
        return dataSource.charactersList
    }
}