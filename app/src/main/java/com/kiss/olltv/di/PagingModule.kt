package com.kiss.olltv.di

import com.kiss.olltv.repository.TvShowPagingSource
import com.kiss.olltv.repository.TvShowRepository
import com.kiss.olltv.repository.TvShowRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PagingModule {
    @Singleton
    @Provides
    fun provideTvShowPagingSource(tvShowPagingSource: TvShowPagingSource): TvShowPagingSource =
        tvShowPagingSource

    @Singleton
    @Provides
    fun provideTvShowRepository(tvShowRepositoryImpl: TvShowRepositoryImpl): TvShowRepository =
        tvShowRepositoryImpl
}