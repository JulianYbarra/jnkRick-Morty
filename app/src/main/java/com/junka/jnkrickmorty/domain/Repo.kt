package com.junka.jnkrickmorty.domain

import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.vo.Resource

interface Repo {
    fun getAllCharacters() : Resource<List<Character>>
}