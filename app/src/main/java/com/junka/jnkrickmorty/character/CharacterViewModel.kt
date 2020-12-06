package com.junka.jnkrickmorty.character

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.domain.Repo
import kotlinx.coroutines.launch

class CharacterViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    fun addToFavorite(character: Character) {
        viewModelScope.launch {
            repo.insert(character)
        }
    }

}