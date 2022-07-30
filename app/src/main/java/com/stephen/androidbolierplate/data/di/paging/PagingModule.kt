package com.stephen.androidbolierplate.data.di.paging

import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import com.stephen.androidbolierplate.presentation.ui.list.BoilerPlatePagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/07/30.
 */

@Module
@InstallIn(SingletonComponent::class)
object PagingModule {

    @Provides
    @Singleton
    fun provideBoilerPlatePagingSource(boilerPlateServiceUtil: BoilerPlateServiceUtil): BoilerPlatePagingSource {
        return BoilerPlatePagingSource(boilerPlateServiceUtil)
    }

}