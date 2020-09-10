package com.junka.jnkrickmorty.presenter.ui.mainfragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.core.Event
import com.junka.jnkrickmorty.core.Resource
import kotlinx.coroutines.Dispatchers

class MainFragmentViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    private val _onNavigationToCharacterDetail = MutableLiveData<Event<CharacterRemote>>()
    val onNavigationToCharacterDetail: LiveData<Event<CharacterRemote>> get() = _onNavigationToCharacterDetail

    val allCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getAllCharacters(1))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun onCharacterItemClick(character: CharacterRemote){
        _onNavigationToCharacterDetail.value = Event(character)
    }
}