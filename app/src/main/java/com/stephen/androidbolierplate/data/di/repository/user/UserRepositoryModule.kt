package com.stephen.androidbolierplate.data.di.repository.user

import com.stephen.androidbolierplate.data.api.user.UserServiceUtil
import com.stephen.androidbolierplate.domain.repository.user.UserRepository
import com.stephen.androidbolierplate.domain.repository.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        userServiceUtil: UserServiceUtil
    ) : UserRepository {
        return UserRepositoryImpl(userServiceUtil)
    }

}