package com.stephen.androidbolierplate.data.di.usecases.auth

import com.stephen.androidbolierplate.domain.repository.auth.AuthRepository
import com.stephen.androidbolierplate.domain.usecases.auth.PostSignInUseCase
import com.stephen.androidbolierplate.domain.usecases.auth.SetUserAccessTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

@Module
@InstallIn(SingletonComponent::class)
object AuthUseCaseModule {

    @Provides
    @Singleton
    fun providePostSignInUseCase(authRepository: AuthRepository): PostSignInUseCase {
        return PostSignInUseCase(authRepository)
    }

    @Provides
    @Singleton
    fun provideSetUserAccessToken(authRepository: AuthRepository): SetUserAccessTokenUseCase {
        return SetUserAccessTokenUseCase(authRepository)
    }

}