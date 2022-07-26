package com.stephen.androidbolierplate.data.di.repository

import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import com.stephen.androidbolierplate.data.repository.boilerplate.BoilerPlateRepository
import com.stephen.androidbolierplate.data.repository.boilerplate.BoilerPlateRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/07/26.
 */

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBoilerPlateRepository(boilerPlateServiceUtil: BoilerPlateServiceUtil) : BoilerPlateRepository {
        return BoilerPlateRepositoryImpl(boilerPlateServiceUtil)
    }

}