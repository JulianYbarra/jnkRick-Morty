package com.junka.jnkrickmorty.character.di

import com.junka.jnkrickmorty.character.service.CharacterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
class CharacterModule {

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService = retrofit.create(CharacterService::class.java)
}