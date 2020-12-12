package com.junka.jnkrickmorty.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.junka.jnkrickmorty.character.action.CharacterAction
import com.junka.jnkrickmorty.character.controller.CharacterController
import com.junka.jnkrickmorty.core.Event
import com.junka.jnkrickmorty.core.Resource
import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.episodes.controller.EpisodeController
import com.junka.jnkrickmorty.home.action.HomeAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel
@ViewModelInject constructor(
    private val characterController: CharacterController,
    private val episodeController: EpisodeController ) : ViewModel() {

    private val _result = MutableLiveData<Resource<HomeAction>>()
    val result: LiveData<Resource<HomeAction>> get() = _result

    companion object{
        const val FIRST_PAGE = 1
    }

    init {
        getCharacters(FIRST_PAGE)
        getEpisodes(FIRST_PAGE)
    }

     fun getCharacters(page : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                characterController.getCharacters(page).collect { characterList ->
                    _result.postValue(Resource.Success(HomeAction.OnCharactersFound(characterList)))
                }
            }
        }
    }

    fun getEpisodes(page : Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                episodeController.getEpisodes(page).collect { episodesList ->
                    _result.postValue(Resource.Success(HomeAction.OnEpisodesFound(episodesList)))
                }
            }
        }
    }

    suspend fun notifyLastVisible(lastVisible: Int) {
        //characterController.checkRequireNewPage(lastVisible)
    }
}