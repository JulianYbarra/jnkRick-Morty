package com.junka.jnkrickmorty.presenter.ui.favorites

import androidx.lifecycle.*
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.presenter.ui.Event
import com.junka.jnkrickmorty.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repo: Repo) : ViewModel() {

    private val _onNavigationToCharacterDetail = MutableLiveData<Event<Character>>()
    val onNavigationToCharacterDetail: LiveData<Event<Character>> get() = _onNavigationToCharacterDetail

    val favoritesCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getCharactersFavorites())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun onCharacterItemClick(character: Character){
        _onNavigationToCharacterDetail.value = Event(character)
    }
}