package com.junka.jnkrickmorty.home.action

import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.EpisodeRemote

sealed class HomeAction{
    class OnCharactersFound(val characterList: List<CharacterRemote>) : HomeAction()
    class OnEpisodesFound(val episodesList: List<EpisodeRemote>) : HomeAction()
}
