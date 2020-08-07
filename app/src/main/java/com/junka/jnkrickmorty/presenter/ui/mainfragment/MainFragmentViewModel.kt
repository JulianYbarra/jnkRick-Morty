package com.junka.jnkrickmorty.presenter.ui.mainfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.junka.jnkrickmorty.data.model.Character
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.vo.Resource
import kotlinx.coroutines.Dispatchers

class MainFragmentViewModel(private val repo: Repo) : ViewModel() {

    val allCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getAllCharacters())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    fun onCharacterItemClick(character: Character){

    }
}

class VMFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}