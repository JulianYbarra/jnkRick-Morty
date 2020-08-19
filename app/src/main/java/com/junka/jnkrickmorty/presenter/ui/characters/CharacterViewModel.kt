package com.junka.jnkrickmorty.presenter.ui.characters

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.domain.Repo
import kotlinx.coroutines.launch

class CharacterViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    fun addToFavorite(characterEntity: CharacterEntity) {
        viewModelScope.launch {
            repo.insert(characterEntity)
        }
    }

}