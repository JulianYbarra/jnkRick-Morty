package com.junka.jnkrickmorty.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.junka.jnkrickmorty.core.BASE_URL
import com.junka.jnkrickmorty.core.DATABASE_NAME
import com.junka.jnkrickmorty.data.local.AppDatabase
import com.junka.jnkrickmorty.domain.remote.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerRoomInstance(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providerCharacterDao(db: AppDatabase) = db.characterDao()

    @Singleton
    @Provides
    fun providerRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    @Singleton
    @Provides
    fun provideWebService(retrofit:Retrofit): WebService = retrofit.create(WebService::class.java)
}