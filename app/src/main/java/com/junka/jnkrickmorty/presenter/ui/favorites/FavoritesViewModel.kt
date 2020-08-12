package com.junka.jnkrickmorty.presenter.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repo: Repo) : ViewModel() {

    val favoritesCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getCharactersFavorites())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}