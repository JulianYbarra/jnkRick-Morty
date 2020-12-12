package com.junka.jnkrickmorty.episodes.repository

import com.junka.jnkrickmorty.data.model.CharacterRemote
import com.junka.jnkrickmorty.data.model.EpisodeRemote
import com.junka.jnkrickmorty.domain.local.EpisodeDao
import com.junka.jnkrickmorty.episodes.service.EpisodeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeService: EpisodeService,
    private val episodeDao: EpisodeDao) {

    fun getEpisodes(page : Int) : Flow<List<EpisodeRemote>> = flow {
        emit(episodeService.getAllEpisode(page).results)
    }
}