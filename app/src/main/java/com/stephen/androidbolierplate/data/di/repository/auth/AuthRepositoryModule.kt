package com.stephen.androidbolierplate.data.di.repository.auth

import com.stephen.androidbolierplate.data.api.AuthServiceUtil
import com.stephen.androidbolierplate.data.util.PrefUtil
import com.stephen.androidbolierplate.domain.repository.auth.AuthRepository
import com.stephen.androidbolierplate.domain.repository.auth.AuthRepositoryImpl
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
class AuthRepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        authServiceUtil: AuthServiceUtil,
        prefUtil: PrefUtil
    ) : AuthRepository {
        return AuthRepositoryImpl(authServiceUtil, prefUtil)
    }

}