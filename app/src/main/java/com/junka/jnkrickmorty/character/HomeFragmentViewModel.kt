package com.junka.jnkrickmorty.character

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.junka.jnkrickmorty.character.action.CharacterAction
import com.junka.jnkrickmorty.character.controller.CharacterController
import com.junka.jnkrickmorty.core.Event
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.domain.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel
@ViewModelInject constructor(
    private val characterController: CharacterController)
    : ViewModel() {

    private val _result = MutableLiveData<Resource<CharacterAction>>()
    val result: LiveData<Resource<CharacterAction>> get() = _result

    init {
        getCharacters(1)
    }

     fun getCharacters(page : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                characterController.getCharacters(page).collect { characterList ->
                    _result.postValue(Resource.Success(CharacterAction.onCharacterFound(characterList)))
                }
            }
        }
    }

    suspend fun notifyLastVisible(lastVisible: Int) {
        //characterController.checkRequireNewPage(lastVisible)
    }
}