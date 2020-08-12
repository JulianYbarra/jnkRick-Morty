package com.junka.jnkrickmorty.presenter.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.junka.jnkrickmorty.data.model.CharacterEntity
import com.junka.jnkrickmorty.domain.Repo
import kotlinx.coroutines.launch

class CharacterViewModel(private val repo: Repo) : ViewModel() {

    fun addToFavorite(characterEntity: CharacterEntity) {
        viewModelScope.launch {
            repo.insert(characterEntity)
        }
    }

}