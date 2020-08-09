package com.junka.jnkrickmorty.presenter.ui.mainfragment

import androidx.lifecycle.*
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.presenter.ui.Event
import com.junka.jnkrickmorty.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainFragmentViewModel(private val repo: Repo) : ViewModel() {

    private val _onNavigationToCharacterDetail = MutableLiveData<Event<Character>>()
    val onNavigationToCharacterDetail: LiveData<Event<Character>> get() = _onNavigationToCharacterDetail

    val allCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getAllCharacters(1))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun onCharacterItemClick(character: Character){
        _onNavigationToCharacterDetail.value = Event(character)
    }
}

class VMFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}