package com.junka.jnkrickmorty.di

import com.junka.jnkrickmorty.data.DataSource
import com.junka.jnkrickmorty.data.DataSourceImpl
import com.junka.jnkrickmorty.domain.Repo
import com.junka.jnkrickmorty.domain.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindRepoImpl(repoImpl: RepoImpl) : Repo

    @Binds
    abstract  fun bindDataSourceImpl(dataSourceImpl: DataSourceImpl) : DataSource

}