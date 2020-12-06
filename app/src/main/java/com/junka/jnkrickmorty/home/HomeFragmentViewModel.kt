package com.junka.jnkrickmorty.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.junka.jnkrickmorty.core.Event
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.domain.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {

    private val _onNavigationToCharacterDetail = MutableLiveData<Event<CharacterRemote>>()
    val onNavigationToCharacterDetail: LiveData<Event<CharacterRemote>> get() = _onNavigationToCharacterDetail

    val allCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getAllCharacters(1))
        } catch (e: Exception) {
            emit(Resource.Failure<List<CharacterRemote>>(e))
        }
    }

    fun onCharacterItemClick(character: CharacterRemote){
        _onNavigationToCharacterDetail.value = Event(character)
    }

    fun test(){

        viewModelScope.launch {

            val episodes =withContext(Dispatchers.IO){
                repo.getAllEpisode(1)
            }


        }
    }
}