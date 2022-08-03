package com.stephen.androidbolierplate.data.di.usecases.user

import com.stephen.androidbolierplate.data.util.PrefUtil
import com.stephen.androidbolierplate.domain.repository.user.UserRepository
import com.stephen.androidbolierplate.domain.usecases.user.GetFriendsUseCase
import com.stephen.androidbolierplate.domain.usecases.user.GetPeopleUseCase
import com.stephen.androidbolierplate.domain.usecases.user.GetUserInfoUseCase
import com.stephen.androidbolierplate.domain.usecases.user.SignOutUseCase
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
object UserUseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserInfoUseCase(userRepository: UserRepository): GetUserInfoUseCase {
        return GetUserInfoUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetPeopleUseCase(userRepository: UserRepository): GetPeopleUseCase {
        return GetPeopleUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetFriendsUseCase(userRepository: UserRepository): GetFriendsUseCase {
        return GetFriendsUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideSignOutUseCase(prefUtil: PrefUtil): SignOutUseCase {
        return SignOutUseCase(prefUtil)
    }

}