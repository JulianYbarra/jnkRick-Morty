package com.junka.jnkrickmorty.episodes.controller

import com.junka.jnkrickmorty.data.model.EpisodeRemote
import com.junka.jnkrickmorty.episodes.repository.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeController @Inject constructor(
    private val episodeRepository: EpisodeRepository) {

    fun getEpisodes(page : Int) : Flow<List<EpisodeRemote>> = episodeRepository.getEpisodes(page)
}