package com.junka.jnkrickmorty.presenter.ui.favorites

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.core.Event
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.model.Character
import kotlinx.coroutines.Dispatchers

class FavoritesViewModel  @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    private val _onNavigationToCharacterDetail = MutableLiveData<Event<CharacterRemote>>()
    val onNavigationToCharacterDetail: LiveData<Event<CharacterRemote>> get() = _onNavigationToCharacterDetail


    fun onCharacterItemClick(character: CharacterRemote){
        _onNavigationToCharacterDetail.value = Event(character)
    }
}