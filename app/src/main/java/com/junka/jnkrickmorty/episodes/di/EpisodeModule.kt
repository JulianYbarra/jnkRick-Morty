package com.junka.jnkrickmorty.episodes.di

import com.junka.jnkrickmorty.episodes.service.EpisodeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
class EpisodeModule {

    @Provides
    fun provideEpisodeService(retrofit: Retrofit): EpisodeService = retrofit.create(EpisodeService::class.java)
}