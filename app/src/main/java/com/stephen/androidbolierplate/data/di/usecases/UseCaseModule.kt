package com.stephen.androidbolierplate.data.di.usecases

import com.stephen.androidbolierplate.domain.repository.boilerplate.BoilerPlateRepository
import com.stephen.androidbolierplate.domain.usecases.GetBoilerPlateUseCase
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
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBoilerPlateUseCase(boilerPlateRepository: BoilerPlateRepository): GetBoilerPlateUseCase {
        return GetBoilerPlateUseCase(boilerPlateRepository)
    }

}